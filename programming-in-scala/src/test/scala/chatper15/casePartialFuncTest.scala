package chatper15

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class casePartialFuncTest extends AnyFlatSpec with Matchers {
  "case pattern" can "use different forms" in {
    // partial function? no. it's complete function.
    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }

    // withDefault is converted as below.
    val withDefaultEx = new Function1[Option[Int], Int] {
      override def apply(v1: Option[Int]): Int = {
        v1 match {
          case Some(x) => x
          case None => 0
        }
      }
    }

    // partial function? yes.
    val withDefaultPartial: PartialFunction[Option[Int], Int] = {
      case Some(x) => x
      case None => 0
    }

    // withDefaultPartial is converted as below.
    val withDefaultPartialEx = new PartialFunction[Option[Int], Int] {
      override def isDefinedAt(x: Option[Int]): Boolean = x match {
        case Some(x) => true
        case None => true
        case _ => false
      }

      override def apply(v1: Option[Int]): Int = v1 match {
        case Some(x) => x
        case None => 0
      }
    }

    withDefault(Some(1)) shouldBe 1
    withDefaultEx(Some(1)) shouldBe 1
    withDefaultPartial(Some(1)) shouldBe 1
    withDefaultPartialEx(Some(1)) shouldBe 1
  }
}
