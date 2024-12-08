package algo.monsieur.aoc
package y24

import scala.annotation.tailrec

object Day_7 extends Day(2024, 7) {

  /**
   *
   *
   * @param input daily puzzle
   * @return
   */
  private def processInput(input: Array[String]): Array[Array[Long]] = {
    input.map(equation =>
      equation.split(":")(0).toLong +:
        equation.split(":")(1).trim.split(" ").map(_.toLong)
    )
  }

  private def eval(tokens: Seq[String]): Long = {
    if (tokens.isEmpty) return 0

    @tailrec
    def process(tokens: Seq[String], currentResult: Long): Long = {
      if (tokens.isEmpty) return currentResult

      val operator = tokens.head
      val secondToken = tokens(1).toLong

      operator match {
        case "+" =>
          process(tokens.tail.tail, currentResult + secondToken)
        case "|" =>
          process(tokens.tail.tail, (currentResult.toString + secondToken.toString).toLong)
        case "*" =>
          process(tokens.tail.tail, currentResult * secondToken)
      }
    }

    process(tokens.tail, tokens.head.toLong)
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Long = {
    val equations: Array[Array[Long]] = processInput(input)
    val operators: List[Char] = List('*', '+')

    equations.filter(equation =>
      val left: Long = equation.head
      val right: Array[Long] = equation.tail
      val options: Array[String] = right.indices.foldLeft(Array("")) { (acc, _) =>
        acc.flatMap(s => operators.map(c => s + c))
      }
      options.exists { o =>
        right.zipWithIndex.reduce {
          case (acc, (value, index)) =>
            o(index) match
              case '*' => (acc._1 * value, 0)
              case '+' => (acc._1 + value, 0)
              case _ => acc
        }._1 == left
      }
    ).map(e => e.head).sum
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Long = {
    val equations = processInput(input)
    val regex = "([0-9]+|[^0-9])".r
    val operators = List('*', '+', '|')

    equations.map { equation =>
      val (head, right) = (equation.head, equation.tail)
      val options = right.indices.foldLeft(Seq("")) { (acc, _) =>
        acc.flatMap(s => operators.map(s + _))
      }
      val newEquations = options.map(option =>
        right.zipWithIndex.map { case (value, idx) => value.toString + option(idx) }.mkString.dropRight(1)
      ).toSet

      if (newEquations.exists(eq => eval(regex.findAllIn(eq).toSeq) == head)) head else 0
    }.sum
  }

}
