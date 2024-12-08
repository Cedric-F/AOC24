package algo.monsieur.aoc

abstract case class Day(var year: Int, var day: Int) {

  def part1(input: Array[String]): Long
  def part2(input: Array[String]): Long

  def compute(): Unit = {
    try {
      val input = Util.fetch_input(year, day)

      println(s"Day $day / $year - Part 1:")
      print(part1(input))

      println(s"\nDay $day / $year - Part 2:")
      print(part2(input))
    } catch {
      case e: Exception =>
        println(s"Error fetching input: {$e.getMessage}")
        Array[String]()
    }
  }
}
