package chapter09

import scala.util.Random

// Usages of Higher Order Function
object HigherOrderFunc2 {
  // fn invoke if random > 3.
  def callwithCondition(fn: => String) = {
    val random = Random.nextInt(5)

    if(random > 3)
      fn
  }

  // fn invoke just after 1 sec.
  def callJustLater(fn: => String) = {
    Thread.sleep(1000L)

    fn
  }

  // fn invoked in try-catch context.
  def callinOtherContext(fn: => String) = {
    try {
      fn
    } catch {
      case e => throw e
    }
  }
}