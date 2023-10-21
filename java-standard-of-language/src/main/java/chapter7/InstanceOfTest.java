package chapter7;

public class InstanceOfTest {
    static class Car {}
    static class FireEngine extends Car {}

    public static void main(String[] args) {
        Car fe = new FireEngine();
        // Reference Type : Car
        // Instance Type : FireEngine

        // Check Reference Type.
        // ???

        // Check Instance Type.
        if(fe instanceof FireEngine) { System.out.println("FireEngine instance"); }
        if(fe instanceof Car) { System.out.println("Car instance"); }
        if(fe instanceof Object) { System.out.println("Object instance"); }
        System.out.println(fe.getClass().getName());
    }
}
