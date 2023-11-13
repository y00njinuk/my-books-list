package chapter09

object ByNameParamter {
  var assertionEnabled = true

  def myAssert(predicate: => Boolean) = {
    if(assertionEnabled && !predicate)
      throw new AssertionError
  }

  def boolAssert(predicate: Boolean) =
    if(assertionEnabled && predicate)
      throw new AssertionError()
}
