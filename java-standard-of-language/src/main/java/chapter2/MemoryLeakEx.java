package chapter2;

import java.util.Vector;

public class MemoryLeakEx {
    public static void main(String[] args) {
        Vector v = new Vector(2144444444);
        Vector v1 = new Vector(21474444);
        Vector v2 = new Vector(214444);
        System.out.println("Memory Leaks");
    }
}
