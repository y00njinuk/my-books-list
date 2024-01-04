package chapter13;

class JParent {
  protected void f() { System.out.println("f");}
}

class JChild extends JParent {
  public JChild() {
    f();
  }
}

class JOhter {
  public JOhter() {
    (new JParent()).f();
  }
}