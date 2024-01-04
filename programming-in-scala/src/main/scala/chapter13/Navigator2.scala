package chapter13

package bobrockets
package navigation {
  private[bobrockets] class Navigator {
    protected[navigation] def userStartChar() = {}

    class LegOfJourney {
      private[Navigator] val distance = 100
    }

    private[this] var speed = 200
  }
}

package launch {
  import navigation._
  object Vehicle {
    private[launch] val guide = new Navigator
  }
}