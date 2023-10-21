package chapter5.item30;

import java.util.function.UnaryOperator;

public class SingletonFactory {
    // Singleton factory pattern
    private static final UnaryOperator<String> IDENTITY_FN = (t) -> t;
    public static UnaryOperator identityFunction() { return IDENTITY_FN; }

    // Sample program to exercise generic singleton
    public static void main(String[] args) {
        String[] strings = { "jute", "hemp", "nylon" };
        UnaryOperator<String> sameString = (UnaryOperator<String>) identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = (UnaryOperator<Number>) identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }
}
