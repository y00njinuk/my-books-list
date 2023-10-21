package chapter7;

public class BindingTest {
    static class Parent {
        int x = 100;
        void method() { System.out.println("Parent Method"); }
    }
    static class Child extends Parent {
        int x = 200;
        void method() { System.out.println("Child Method"); }
        void read() {
            System.out.println("p.x = " + super.x);
            System.out.println("c.x = " + this.x);
        }
    }

    public static void main(String[] args) {
        Parent p = new Child();
        Child c = new Child();

        System.out.println("p.x = " + p.x); // 100
        p.method();                         // Child Method

        System.out.println("c.x = " + c.x); // 200
        c.method();                         // Child Method
        c.read();
    }
}
