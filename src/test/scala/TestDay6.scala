package algo.monsieur.aoc

import y24.Day_6.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay6 extends AnyFunSuite {

  private val input: Array[String] = "".split("\n")

  private val EXPECTED_RESULT_PART_1: Int = 0
  private val EXPECTED_RESULT_PART_2: Int = 0

  test("Part 1 sample result is OK") {
    assert(part1(input) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(input) == EXPECTED_RESULT_PART_2)
  }
}