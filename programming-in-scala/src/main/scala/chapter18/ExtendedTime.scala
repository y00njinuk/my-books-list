package chapter18

class ExtendedTime {
  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_= (x: Int): Unit = {
    require(0 <= x && x < 24) // invariant
    h = x
  }

  def minute: Int = m
  def minute_= (x: Int): Unit = {
    require(0 <= x && x < 60) // invariant
    m = x
  }
}

object ExtendedTime {
  def main(args: Array[String]): Unit = {
    val extendedTime = new ExtendedTime

    extendedTime.hour = 1
    extendedTime.minute = 10

    println(extendedTime.hour)
    println(extendedTime.minute)
  }
}
