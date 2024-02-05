package chapter19

object ListUsageExam {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(3, 6, 2, 9, 21)

    // 3, 6, 2, 9
    // O(n-1) ≒ O(n)
    val res1: List[Int] = list.init
    println(res1)

    // 21, 9, 2, 6, 3
    // O(n)
    val res2: List[Int] = list.reverse
    println(res2)
  }
}
