package chapter5.item30.compareFruits.problem1;

/**
 * In this code, we are able to achieve our objective of being able to compare the same types,
 * that is, apples with apples and oranges with oranges.
 * When we compare an apple with an orange we get an error which is what we want.
 */
public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(4);
        apple1.compareTo(apple2);

        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        orange1.compareTo(orange2);

//        apple1.compareTo(orange1); // Error.
    }
}

/*
* Problem Definition
*
* The problem here is that the code for implementing the compareTo() method is duplicated for Apple and Orange class.
* And it will be duplicated more in all the classes that we extend from the Fruit, for creating new fruits in the future.
* The amount of repeated code in our example is less but in real world the repeated code can be of hundreds of lines in each class.
*
* */