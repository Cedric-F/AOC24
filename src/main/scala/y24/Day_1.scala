package algo.monsieur.aoc
package y24

object Day_1 extends Day(2024, 1) {

  /**
   * Transpose 2 columns of Int
   *
   * @param input daily puzzle
   * @return
   */
  private def processInput(input: Array[String]): (Array[Int], Array[Int]) = {
    input.foldLeft((Array[Int](), Array[Int]())) { (acc, line) =>
      val s = line.split("\\s+")
      (acc._1 :+ s(0).toInt, acc._2 :+ s(1).toInt)
    }
  }

  /**
   * Sum up the differences between each Nth smallest elements of 2 lists
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Int = {
    var (l1, l2) = processInput(input)

    l2 = l2.sorted

    val result: Int = l1.sorted.zipWithIndex.foldLeft(0) {
      case (acc, (value, index)) =>
        acc + Math.abs(value - l2(index))
    }

    result
  }

  /**
   * Sum up the products of each element in l1 and its corresponding frequency in l2.
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Int = {
    val (l1, l2) = processInput(input)

    val group: Map[Int, Int] = l2.groupBy(identity).view.mapValues(_.length).toMap
    val result: Int = l1.foldLeft(0) {
      (acc, value) => acc + value * group.getOrElse(value, 0)
    }
    result
  }
}
