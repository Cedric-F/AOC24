package algo.monsieur.aoc
package y24

import y24.Day_7.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay7 extends AnyFunSuite {

  private val input: Array[String] = "190: 10 19\n3267: 81 40 27\n83: 17 5\n156: 15 6\n7290: 6 8 6 15\n161011: 16 10 13\n192: 17 8 14\n21037: 9 7 18 13\n292: 11 6 16 20".split("\n")

  private val EXPECTED_RESULT_PART_1: Long = 3749
  private val EXPECTED_RESULT_PART_2: Long = 11387

  test("Part 1 sample result is OK") {
    assert(part1(input) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(input) == EXPECTED_RESULT_PART_2)
  }
}