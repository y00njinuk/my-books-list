package chapter12

import scala.annotation.tailrec

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  override def toString: String = numer + "/" + denom
  @tailrec private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  override def compare(that: Rational): Int = (this.numer * that.denom) - (that.numer * this.denom)
}
