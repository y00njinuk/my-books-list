package chapter02

object ImmutableVar {
  def main(args: Array[String]): Unit = {
    var v = Set(1,2,3)
    v += 5

    silly(v)
    println(v)
  }

  def silly(v: Set[Int]): Unit = {
    // v += 6   // here is compile error. v is val.
                // parameters to method in Scala are 'val' by default.
    println(s"length of v : ${v.size}")
  }
}
