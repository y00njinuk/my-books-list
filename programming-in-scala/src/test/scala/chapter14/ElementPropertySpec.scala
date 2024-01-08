package chapter14

import chapter10.Element.elem
import org.scalatest.matchers.must.Matchers.{convertToAnyMustWrapper, equal}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class ElementPropertySpec extends AnyWordSpec with ScalaCheckPropertyChecks {
  "elem result" must {
    "have passed width" in {
      forAll { (w:Int) =>
        whenever (w > 0) {
          elem('x', w, 3).width must equal (w)
        }
      }
    }
  }
}
