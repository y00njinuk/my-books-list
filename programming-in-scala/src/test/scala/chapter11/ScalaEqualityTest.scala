package chapter11

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class ScalaEqualityTest extends AnyFlatSpec {
  "== or !=" should "only compare values, regardless of the type AnyVal or AnyRef" in {
    // AnyVal
    val intValue = 4
    (intValue == 2 * 2) shouldBe true

    // AnyRef
    val str1 = new String("AnyRef")
    val str2 = new String("AnyRef")
    str1 == str2 shouldBe true

    // AnyRef with null-safe
    val nullStr1 = null
    val nullStr2 = null
    nullStr1 == nullStr2 shouldBe true
  }

  "equals method" should "only compare values, regardless of the type AnyVal or AnyRef. but not null-safe" in {
    // AnyVal
    val intValue = 4
    intValue.equals(2 * 2) shouldBe true

    // AnyRef
    val str1 = new String("AnyRef")
    val str2 = new String("AnyRef")
    str1.equals(str2) shouldBe true

    // AnyRef with not null-safe
    val nullStr1 = null
    val nullStr2 = null
    assertThrows[java.lang.NullPointerException](nullStr1.equals(nullStr2))
  }

  "eq or ne" should "compare the references to point to the same object in a heap" in {
    // AnyRef
    val str1 = new String("AnyRef")
    val str2 = new String("AnyRef")
    str1 eq str2 shouldBe false
    str1 ne str2 shouldBe true

    // AnyRef with null-safe
    val nullStr1 = null
    val nullStr2 = null
    nullStr1 eq nullStr2 shouldBe true
    nullStr1 ne nullStr2 shouldBe false
  }
}
