package algo.monsieur.aoc

import y24.Day_2.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay2 extends AnyFunSuite {

  private val input: Array[String] = "7 6 4 2 1\n1 2 7 8 9\n9 7 6 2 1\n1 3 2 4 5\n8 6 4 4 1\n1 3 6 7 9".split("\n")

  private val EXPECTED_RESULT_PART_1: Int = 2
  private val EXPECTED_RESULT_PART_2: Int = 4

  test("Part 1 sample result is OK") {
    assert(part1(input) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(input) == EXPECTED_RESULT_PART_2)
  }
}