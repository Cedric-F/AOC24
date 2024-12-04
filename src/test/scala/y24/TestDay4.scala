package algo.monsieur.aoc
package y24

import y24.Day_4.*

import org.scalatest.funsuite.AnyFunSuite

class TestDay4 extends AnyFunSuite {

  private val sample1: Array[String] = "MMMSXXMASM\nMSAMXMSMSA\nAMXSXMAAMM\nMSAMASMSMX\nXMASAMXAMM\nXXAMMXXAMA\nSMSMSASXSS\nSAXAMASAAA\nMAMMMXMMMM\nMXMXAXMASX".split("\n")
  private val sample2: Array[String] = ".M.S......\n..A..MSMS.\n.M.S.MAA..\n..A.ASMSM.\n.M.S.M....\n..........\nS.S.S.S.S.\n.A.A.A.A..\nM.M.M.M.M.\n..........".split("\n")

  private val EXPECTED_RESULT_PART_1: Int = 18
  private val EXPECTED_RESULT_PART_2: Int = 9

  test("Part 1 sample result is OK") {
    assert(part1(sample1) == EXPECTED_RESULT_PART_1)
  }
  test("Part 2 sample result is OK") {
    assert(part2(sample2) == EXPECTED_RESULT_PART_2)
  }
}