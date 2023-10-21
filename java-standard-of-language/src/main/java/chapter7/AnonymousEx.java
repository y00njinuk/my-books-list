package chapter7;

public class AnonymousEx {
    Object iv = new Object() { void method() {} };
    static Object cv = new Object() { void method() {} };

    void myMethod() {
        Object lv = new Object() { void method() {} };
    }
}
