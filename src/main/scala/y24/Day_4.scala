package algo.monsieur.aoc
package y24

import scala.util.matching.Regex

object Day_4 extends Day(2024, 4) {

  /**
   *
   *
   * @param input daily puzzle
   * @return
   */
  private def processInput(input: Array[String]): Unit = {
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Int = {
    val borderlessInput: Array[String] = input.map(r => "." * 4 + r + "." * 4) ++ ((("." * (input(0).length + 8)) + "\n") * 4).split("\n")
    val xmas: Regex = """(XMAS)|(SAMX)""".r
    input.zipWithIndex.map(
      (row, y) => {
        row.zipWithIndex.map {
          (col, x) =>
            val nx: Int = x + 4
            val hor: String = borderlessInput(y).substring(nx, nx + 4)
            val ver: String = "" + borderlessInput(y)(nx) + borderlessInput(y + 1)(nx) + borderlessInput(y + 2)(nx) + borderlessInput(y + 3)(nx)
            val diaR: String = "" + borderlessInput(y)(nx) + borderlessInput(y + 1)(nx + 1) + borderlessInput(y + 2)(nx + 2) + borderlessInput(y + 3)(nx + 3)
            val diaL: String = "" + borderlessInput(y)(nx) + borderlessInput(y + 1)(nx - 1) + borderlessInput(y + 2)(nx - 2) + borderlessInput(y + 3)(nx - 3)
            Seq(hor, ver, diaR, diaL).map {
              string => xmas.findAllMatchIn(string).length
            }.sum
          }.sum
      }
    ).sum
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Int = {
    val axy: Array[(Int, Int)] = input.zipWithIndex.flatMap { case (row, y) => row.zipWithIndex.map {
      case (c, x) => if (c == 'A') (y, x) else (-1, -1) }.filter(a => a._1 != -1)
    }

    axy.count(a =>
      try {
        val topL = input(a._1 - 1)(a._2 - 1)
        val topR = input(a._1 - 1)(a._2 + 1)
        val botL = input(a._1 + 1)(a._2 - 1)
        val botR = input(a._1 + 1)(a._2 + 1)
        val diaR: String = "" + topL + "A" + botR
        val diaL: String = "" + topR + "A" + botL
        (diaR.equals("SAM") || diaR.equals("MAS")) && (diaL.equals("SAM") || diaL.equals("MAS"))
      }
      catch
        case exception: Exception => false
    )
  }
}
