package chapter08

import scala.io.Source

object LongLines {
  private def processLine(filename: String, width: Int, line: String) = {
    if(line.length > width)
      println(filename + ": " + line.trim)
  }

  def processFile(filename: String, width: Int): Unit = {
    val source = Source.fromFile(filename)
    for(line <- source.getLines()) {
      processLine(filename, width, line)
    }
  }
}
