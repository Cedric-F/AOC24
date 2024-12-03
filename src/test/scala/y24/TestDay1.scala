package algo.monsieur.aoc
package y24

import y24.Day_1.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay1 extends AnyFunSuite {

  private val input: Array[String] = "3   4\n4   3\n2   5\n1   3\n3   9\n3   3".split("\n")
  
  private val EXPECTED_RESULT_PART_1: Int = 11
  private val EXPECTED_RESULT_PART_2: Int = 31

  test("Part 1 sample result is OK") {
    assert(part1(input) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(input) == EXPECTED_RESULT_PART_2)
  }
}