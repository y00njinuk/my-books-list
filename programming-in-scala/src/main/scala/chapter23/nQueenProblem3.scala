package chapter23

object nQueenProblem3 {
  def queens(n: Int): List[List[(Int, Int)]] = {
    def placeQueens(k: Int): List[List[(Int, Int)]] =
      if (k == 0)
        List(List())
      else
        placeQueens(k - 1).flatMap { queens =>
          (1 to n).flatMap { column =>
            val queen = (k, column)
            if (isSafe(queen, queens)) Some(queen :: queens) else None
          }
        }

    placeQueens(n)
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int)): Boolean =
    q1._1 == q2._1 || q1._2 == q2._2 || (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

  def main(args: Array[String]): Unit = {
    println(queens(4))
  }
}
