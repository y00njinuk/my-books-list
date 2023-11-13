package chapter08

object NamedArgument {
  def speed(distance: Float, time: Float): Float = distance / time

  def main(args: Array[String]): Unit = {
    speed(distance = 100, time = 10)
    speed(time = 10, distance = 100)
  }
}
