package chapter09

object ByNameParamter {
  var assertionEnabled = true

  def myAssert(predicate: () => Boolean) = {
    if (assertionEnabled && !predicate())
      throw new AssertionError
  }

  def myAssertByNamedParamter(predicate: => Boolean) = {
    if(assertionEnabled && !predicate)
      throw new AssertionError
  }

  def boolAssert(predicate: Boolean) =
    if(assertionEnabled && predicate)
      throw new AssertionError()

  def main(args: Array[String]): Unit = {
    myAssert(() => 5 > 3)
    myAssertByNamedParamter(5 > 3)
    boolAssert(5 > 3)
  }
}
