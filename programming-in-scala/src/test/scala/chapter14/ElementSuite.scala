package chapter14

import chapter10.Element.elem
import org.scalatest.funsuite.AnyFunSuite

class ElementSuite extends AnyFunSuite {

  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}
