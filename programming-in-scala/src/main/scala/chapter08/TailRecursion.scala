package chapter08

import scala.annotation.tailrec

object TailRecursion {
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1

  @tailrec
  def bang(x: Int): Int =
    if (x == 0) throw new Exception("bang!")
    else bang(x - 1)

  def main(args: Array[String]) {
    try {
      boom(3)
    } catch {
      case ex: Exception => ex.printStackTrace()
    }

    try {
      bang(5)
    } catch {
      case ex: Exception=> ex.printStackTrace()
    }
  }
}
