package chapter13

class SParent {
  protected def f() = { println("f") }
}

class SChild extends SParent {
  def SChild() = {
    f()
  }
}

class SOhter {
  // Symbol f is inaccessible from this place
  // (new SParent).f()
}