package chapter13.QnA

// https://github.com/databricks/scala-style-guide#privatethis
class MyClass(private val field1: Int = _,
              private[this] val field2: Int = _) {

  def perSenstiveMethod(): Unit = {
    var i = 0
    while (i < 100000) {
      field1  // This might invoke a virtual method call.
      field2  // This is just a field access.
      i += 1
    }
  }
}

