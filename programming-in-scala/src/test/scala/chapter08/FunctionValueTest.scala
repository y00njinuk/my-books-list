package chapter08

import org.scalatest.flatspec.AnyFlatSpec

class FunctionValueTest extends AnyFlatSpec {

  "Function Value" should "equals to object mixin FunctionN trait" in {
    val name = "world"

    val greeting = () => s"hello, $name"
    val anonfun0 = new Function0[String] {
      override def apply(): String = s"hello, $name"
    }

    assert(greeting != anonfun0)      // not equals. why? they are each object in runtime.
    assert(greeting() == anonfun0())  // equals. why? they are same method return same value.
  }
}
