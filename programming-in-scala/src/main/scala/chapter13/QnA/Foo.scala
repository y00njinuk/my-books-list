package chapter13.QnA

class Foo {
  private[this] var bar: Int = _
  private var baz: Int = _

  def setter(bar: Int, baz: Int): Unit = {
    this.bar = bar
    this.baz = baz
  }
  override def toString: String =
    s"""bar = $bar, baz = $baz"""
}

object Foo {
  private def setDefault(foo: Foo): Unit = {
    // "foo.bar = 0" was not compiled. Why? 'bar' is private[this]
    // You should set value to 'bar' by invoke 'setBar' method.
    foo.baz = 0
  }

  def main(args: Array[String]): Unit = {
    val obj1 = new Foo
    val obj2 = new Foo

    obj1.setter(bar = 1, baz = 1)
    obj2.setter(bar = 1, baz = 1)
    Foo.setDefault(obj1)

    println(obj1.toString) // bar = 1, baz = 0
    println(obj2.toString) // bar = 1, baz = 1
  }
}