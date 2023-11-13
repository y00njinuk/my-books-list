package chapter08

object RepeatedParameter {
  def echo(args: String*) = for (arg <- args) println(arg)

  def main(args: Array[String]): Unit = {
    val arr = Array("Waht's", "up", "doc?")
    // echo(arr): compile error.
    echo(arr: _*) // equal to "echo("What's", "up", "doc?")"
  }
}
