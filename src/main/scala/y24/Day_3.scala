package algo.monsieur.aoc
package y24

import java.util.regex.Pattern
import scala.util.matching.Regex

object Day_3 extends Day(2024, 3) {

  /**
   * Sum up the products of all mul(x,y) operations
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Int = {
      """mul\((\d+),(\d+)\)""".r.findAllMatchIn(input.mkString).map(m => m.group(1).toInt * m.group(2).toInt).sum
  }

  /**
   * Sum up the products of all mul(x,y) operations within a do()...don't() segment
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Int = {
    val pattern: Regex = """do\(\)(.*?mul\((\d+),(\d+)\).*?)don't\(\)""".r
    val in: String = "do()" + input.mkString + "don't()"
    pattern.findAllMatchIn(in).flatMap { dos =>
      """mul\((\d+),(\d+)\)""".r.findAllMatchIn(dos.group(1)).map(mul => mul.group(1).toInt * mul.group(2).toInt)
    }.sum
  }
}
