package chapter23

object nQueenProblem2 {
  def solveNQueens(n: Int): List[List[String]] = {
    def placeQueens(k: Int): List[List[Int]] = k match {
      case 0 => List(List())
      case _ => for {
        queens <- placeQueens(k - 1)
        column <- List.range(1, n + 1)
        if isSafe(column, queens, 1)
      } yield column :: queens
    }

    def isSafe(col: Int, queens: List[Int], delta: Int): Boolean = queens match {
      case Nil => true
      case queen :: rest =>
        queen != col &&
          queen != col - delta &&
          queen != col + delta &&
          isSafe(col, rest, delta + 1)
    }

    def createBoard(queens: List[Int]): List[String] = {
      queens.map(queen => "." * (queen - 1) + "Q" + "." * (n - queen))
    }

    placeQueens(n).map(createBoard)
  }

  def main(args: Array[String]): Unit = {
    val solutions = solveNQueens(4)
    solutions.foreach { solution =>
      solution.foreach(println)
      println()
    }
  }
}
