package chapter12

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class RationalTest extends AnyFlatSpec with Matchers {
  it should "return greater or lesser Rational " in {
    val rational1 = new Rational(1, 2)
    val rational2 = new Rational(3, 4)

    // when use compare operator, call compare method
    (rational1 < rational2) shouldBe true
    (rational1 > rational2) shouldBe false
  }
}
