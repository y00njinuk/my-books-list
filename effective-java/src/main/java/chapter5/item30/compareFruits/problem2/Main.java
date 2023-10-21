package chapter5.item30.compareFruits.problem2;

/**
 * In this step, we get rid of the repeated code of compareTo() method by moving it to a superclass.
 * Our extended classes Apple and Orange are no longer polluted with common code.
 */
public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(4);
        apple1.compareTo(apple2);

        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        orange1.compareTo(orange2);

        apple1.compareTo(orange1);  // No Error.
    }
}

/*
* Problem Definition
*
* Here the problem is that we are now able to compare different types, comparing apples to oranges no longer gives us an error:
*
* */