package algo.monsieur.aoc
package y24

object Day_5 extends Day(2024, 5) {

  /**
   *
   *
   * @param input daily puzzle
   * @return
   */
  private def processInput(input: Array[String]): (Map[Int, Seq[Int]], Array[Array[Int]]) = {
    val clean_input = input.mkString("\n").split("\n\n")
    val rules: Map[Int, Seq[Int]] = clean_input(0).split("\n")
      .map(_.split("\\|").map(_.toInt))
      .groupBy(_(0))
      .view.mapValues(_.map(_(1)).toSeq)
      .toMap
    val updates: Array[Array[Int]] = clean_input(1).split("\n").map(e => e.split(",").map(_.toInt))
    (rules, updates)
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Long = {
    val (rules, updates) = processInput(input)
    updates.filter(update =>
      update.zipWithIndex.forall {
        case (page, index) =>
          val segment = update.drop(index + 1)
          segment.intersect(rules.getOrElse(page, Seq())).length == segment.length
      }
    ).map(update => update(update.length / 2)).sum
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Long = {
    val (rules, updates) = processInput(input)
    updates.filter(update =>
      !update.zipWithIndex.forall {
        (page, index) =>
          val segment = update.drop(index + 1)
          segment.intersect(rules.getOrElse(page, Seq())).length == segment.length
      }
    ).map(update => update.sortWith((a, b) => rules(a).contains(b)))
    .map(update => update(update.length / 2)).sum
  }
}
