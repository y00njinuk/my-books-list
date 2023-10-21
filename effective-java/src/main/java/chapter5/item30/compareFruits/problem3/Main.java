package chapter5.item30.compareFruits.problem3;

/**
 * To restrict comparison of different types, we introduce a type parameter T.
 * So that the comparable Fruit<Apple> cannot be compared to comparable Fruit<Orange>.
 * Note our Apple and Orange classes; they now inherit from the types Fruit<Apple> and Fruit<Orange> respectively.
 * Now if we try to compare different types, the IDE shows an error, our desired behaviour:
 */
public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(4);
        apple1.compareTo(apple2);

        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        orange1.compareTo(orange2);

//        apple1.compareTo(orange1);  // Error.
    }
}

/*
 * Problem Definition
 *
 * But in this step, our Fruit class doesn't compile.
 * The getSize() method of T is unknown to the compiler.
 * This is because the type parameter T of our Fruit class doesn't have any bound.
 * So, the T could be any class, it is not possible that every class would have a getSize() method.
 * So the compiler is right in not recognizing the getSize() method of T.
 *
 * */