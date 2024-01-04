package chapter13;

class JOuter {
  class Inner {
    private void f() { System.out.println("f"); }

    class InnerMost {
      InnerMost() {
        f();
      }
    }
  }

  JOuter() {
    new Inner().f(); // possible.
  }
}
