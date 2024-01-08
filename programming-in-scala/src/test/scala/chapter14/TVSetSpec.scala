package chapter14

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

class TVSetSpec extends AnyFeatureSpec with GivenWhenThen {
  Feature("TV power button") {
    Scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      When("the power button is pressed")
      Then("The TV should switch on")
      pending // 실제로 구현이 되지 않았을 명시하는 메서드
    }
  }

}
