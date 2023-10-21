package chapter6;

public class OverLoadingEX {
    public static void main(String[] args) {
        add(3, 3L); // int, long
        add(3L, 3); // long, int
//        add(3, 3);  // compile error.
    }

    static void add(int a, long b) {
        // do something.
    }

    static void add(long a, int b) {
        // do something.
    }
}
