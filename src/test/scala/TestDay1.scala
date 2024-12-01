package algo.monsieur.aoc

import y24.Day_1.*
import org.scalatest.funsuite.AnyFunSuite

class TestDay1 extends AnyFunSuite {
  test("Part 1 sample result is OK") {
    val input: Array[String] = "3   4\n4   3\n2   5\n1   3\n3   9\n3   3".split("\n")
    assert(part1(input) == 11)
  }
  test("Part 2 sample result is OK") {
    val input: Array[String] = "3   4\n4   3\n2   5\n1   3\n3   9\n3   3".split("\n")
    assert(part2(input) == 31)
  }
}