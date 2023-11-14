package chapter09

import java.io.{File, PrintWriter}
import java.util.Date

object LoanPattern {
  def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)

    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriterWithCurrying(file: File)(op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)

    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def main(args: Array[String]): Unit = {
    val file = new File("data.txt")

    withPrintWriter(file, writer => writer.println(new java.util.Date))

    withPrintWriterWithCurrying(file) { writer =>
      writer.println(new java.util.Date)
    }
  }
}
