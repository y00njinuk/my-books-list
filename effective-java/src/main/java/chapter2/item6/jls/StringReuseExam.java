package chapter2.item6.jls;

/**
 * @see https://docs.oracle.com/javase/specs/jls/se13/html/jls-3.html#jls-3.10.5
 */
public class StringReuseExam {
    public static String hello = "Hello";

    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.println(hello == "Hello");
        System.out.println(StringReuseExam.hello == hello);
        System.out.println(hello == ("Hel"+"lo"));

        // false.
        // Strings computed by concatenation at run time are newly created and therefore distinct.
        System.out.println(hello == ("Hel"+lo));
        System.out.println(hello == ("Hel"+lo).intern());
    }
}

