package chapter02

import scala.collection.mutable

object MutableVal {
  def main(args: Array[String]): Unit = {
    val v = mutable.Set(1, 2, 3)
    v += 5

    silly(v)
    println(v)
  }

  def silly(v: mutable.Set[Int]): Unit = {
    v += 6
    println(s"length of v : ${v.size}")
  }
}
