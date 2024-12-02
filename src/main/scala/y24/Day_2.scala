package algo.monsieur.aoc
package y24

object Day_2 extends Day(2024, 2){

  private def processInput(input: Array[String]): Array[Array[Int]] = {
    input.map(line => line.split(" ").map(_.toInt))
  }

  override def part1(input: Array[String]): Int = {
    val reports = processInput(input)

    reports.count(report =>
      val asc: Boolean = report(0) < report(1)
      report.init.zipWithIndex.forall { (value, index) =>
        val next: Int = report(index + 1)
        val diff: Int = Math.abs(value - next)
        diff <= 3 && diff >= 1 && (if (asc) value < next else value > next)
      }
    )
  }

  override def part2(input: Array[String]): Int = {
    val reports = processInput(input)

    reports.count(report =>
      report.zipWithIndex.exists {
        case (value, index) =>
          val updatedReport: Array[Int] = report.patch(index, Nil, 1)
          val asc: Boolean = updatedReport(0) < updatedReport(1)
          updatedReport.init.zipWithIndex.forall { (value, index) =>
            val next: Int = updatedReport(index + 1)
            val diff: Int = Math.abs(value - next)
            diff <= 3 && diff >= 1 && (if (asc) value < next else value > next)
          }
      }
    )
  }
}