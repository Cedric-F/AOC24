package algo.monsieur.aoc
package y24

import y24.Day_6.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay6 extends AnyFunSuite {

  private val input: Array[String] = "....#.....\n.........#\n..........\n..#.......\n.......#..\n..........\n.#..^.....\n........#.\n#.........\n......#...".split("\n")

  private val EXPECTED_RESULT_PART_1: Int = 41
  private val EXPECTED_RESULT_PART_2: Int = 6

  test("Part 1 sample result is OK") {
    assert(part1(input) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(input) == EXPECTED_RESULT_PART_2)
  }
}