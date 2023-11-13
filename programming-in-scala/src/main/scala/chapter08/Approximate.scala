package chapter08

import scala.annotation.tailrec

object Approximate {
  def isGoodEnough(guess: Double): Boolean = {
    println("guess [" + guess + "]")
    math.abs(guess*guess - 2.0)  <  1.0E-6
  }

  def improve(guess: Double): Double =
    (guess + 2.0/guess)/2.0

  @tailrec
  def approximate(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else approximate(improve(guess))

  def approximateLoop(initialGuess: Double): Double = {
    var guess = initialGuess
    while (!isGoodEnough(guess))
      guess = improve(guess)
    guess
  }

  def main(args: Array[String]) {
    approximate(3.3)
    approximateLoop(3.3)
  }
}
