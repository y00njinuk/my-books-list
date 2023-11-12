package chapter08

import scala.io.Source

object LongLinesImproved {
  def processFile(filename: String, width: Int): Unit = {
    // 1. define local method
    def processLine(line: String) = {
      if (line.length > width)
        println(filename + ": " + line.trim)
    }

    val source = Source.fromFile(filename)
    for(line <- source.getLines()) {
      processLine(line)
    }
  }
}