package algo.monsieur.aoc

import scala.io.Source
import java.net.HttpURLConnection
import java.net.URL
import scala.util.Using

object Util {
  def fetch_input(year: Int, day: Int): Array[String] = {
    val sessionToken = sys.env.getOrElse("AOC_SESSION",
      throw new RuntimeException("Environment variable AOC_SESSION not set"))

    val input_url = s"https://adventofcode.com/$year/day/$day/input"
    val connection = new URL(input_url).openConnection().asInstanceOf[HttpURLConnection]

    connection.setRequestMethod("GET")
    connection.setRequestProperty("Cookie", s"session=$sessionToken")

    Using.resource(Source.fromInputStream(connection.getInputStream)) { source =>
      source.getLines.toArray
    }
  }
}
