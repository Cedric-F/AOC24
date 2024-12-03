package algo.monsieur.aoc
package y24

import y24.Day_3.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay3 extends AnyFunSuite {

  private val sample1: Array[String] = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))".split("\n")
  private val sample2: Array[String] = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))".split("\n")

  private val EXPECTED_RESULT_PART_1: Int = 161
  private val EXPECTED_RESULT_PART_2: Int = 48

  test("Part 1 sample result is OK") {
    assert(part1(sample1) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(sample2) == EXPECTED_RESULT_PART_2)
  }
}