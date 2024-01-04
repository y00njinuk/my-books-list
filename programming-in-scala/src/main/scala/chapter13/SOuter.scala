package chapter13

class SOuter {
  class Inner {
    private def f() = { println("f") }

    class InnerMost {
      def InnerMost() = {
        f()
      }
    }
  }

  def SOuter() {
    // Symbol f is inaccessible from this place
    // (new Inner).f()
  }
}
