package algo.monsieur.aoc
package y24

import scala.util.control.Breaks.{break, breakable}

object Day_6 extends Day(2024, 6) {

  /**
   *
   *
   * @param input daily puzzle
   * @return
   */
  private def processInput(input: Array[String]): Unit = {
  }

  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part1(input: Array[String]): Long = {
    val map = input.zipWithIndex.flatMap { case (line, y) =>
      line.zipWithIndex.map { case (c, x) => (y, x) -> c }
    }.toMap

    val start = map.collectFirst {
      case (pos, c) if "^v<>".contains(c) => pos -> c
    }.get

    val directions = Map('^' -> (-1, 0), 'v' -> (1, 0), '<' -> (0, -1), '>' -> (0, 1))
    val rotation = Map('^' -> '>', '>' -> 'v', 'v' -> '<', '<' -> '^')

    Iterator
      .iterate((Set(start._1), start._1, start._2, true)) { case (visited, (y, x), dir, continue) =>
        val (dy, dx) = directions(dir)
        val nextPos = (y + dy, x + dx)
        map.get(nextPos) match {
          case Some('#') => (visited, (y, x), rotation(dir), true)
          case Some(_)   => (visited + nextPos, nextPos, dir, true)
          case None      => (visited, (y, x), dir, false)
        }
      }
      .takeWhile(_._4)
      .toSeq.last._1.size
  }


  /**
   *
   *
   * @param input daily puzzle
   * @return an int
   */
  override def part2(input: Array[String]): Long = {
    val map = input.zipWithIndex.flatMap((line, y) =>
      line.zipWithIndex.map((c, x) => (y, x) -> c)
    ).toMap

    val start = map.collectFirst { case (pos, c) if "^v<>".contains(c) => pos -> c }.get
    val directions = List('^' -> (-1, 0), '>' -> (0, 1), 'v' -> (1, 0), '<' -> (0, -1))

    def causesLoop(mapWithObstacle: Map[(Int, Int), Char]): Boolean = {
      val visited = collection.mutable.Set.empty[(Int, Int, Int)]
      var pos = start._1
      var dirIdx = directions.indexWhere(_._1 == start._2)

      while (true) {
        val state = (pos._1, pos._2, dirIdx)
        if (visited.contains(state)) return true
        visited += state

        val (dy, dx) = directions(dirIdx)._2
        val nextPos = (pos._1 + dy, pos._2 + dx)
        mapWithObstacle.get(nextPos) match {
          case Some('#') => dirIdx = (dirIdx + 1) % 4
          case Some(_) => pos = nextPos
          case None => return false
        }
      }
      false
    }

    map.keys.count { obstaclePos =>
      if (map(obstaclePos) == '.' || map(obstaclePos) == '#') {
        val mapWithObstacle = map + (obstaclePos -> '#')
        causesLoop(mapWithObstacle)
      } else false
    }
  }
}
