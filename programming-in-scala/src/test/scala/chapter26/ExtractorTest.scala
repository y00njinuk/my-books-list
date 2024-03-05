package chapter26

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.util.matching.Regex

class ExtractorTest extends AnyFlatSpec with Matchers {

  "userTwiceUpper" should "check upper string twice" in {
    def userTwiceUpper(s: String): String = s match {
      // wrong: "x @ UpperCase" (should match unapply method)
      case EMail(Twice(x @ UpperCase()), domain) =>
        "match : " + x + " in domain " + domain
      case _ =>
        "no match"
    }

    userTwiceUpper("DIDI@hotmail.com") shouldBe "match : DI in domain hotmail.com"
    userTwiceUpper("DIDO@hotmail.com") shouldBe "no match"
    userTwiceUpper("didi@hotmail.com") shouldBe "no match"
  }

  "isTomInDotCom" should "check \"tom\" in some string" in {
    def isTomInDotCom(s: String): Boolean = s match {
      case EMail("tom", Domain(Seq("com", _*))) => true
      case _ => false
    }

    isTomInDotCom("tom@sun.com") shouldBe true
    isTomInDotCom("peter@sun.com") shouldBe false
    isTomInDotCom("tom@acm.org") shouldBe false
  }

  "ExpandedEMail" should "extract each element" in {
    val ExpandedMail(name, topDom, subDoms @ _*) = "tom@support.epfl.ch"

    name shouldBe "tom"
    topDom shouldBe "ch"
    subDoms should equal (List("epfl", "support"))
  }

  "Regex" should "extract each element from regular expression" in {
    val Decimal = new Regex("""(-)?(\d+)(\.\d*)?""")

    val Decimal(sign, integerpart, decimalpart) = "1.0"

    sign shouldBe null
    integerpart shouldBe "1"
    decimalpart shouldBe ".0"
  }
}
