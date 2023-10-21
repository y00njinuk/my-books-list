package chapter5.item30.compareFruits.solution;

/**
 * So, we tell the compiler that our T is a subtype of Fruit. In other words, we specify the upper bound T extends Fruit<T>. 
 * This makes sure that only subtypes of Fruit are allowed as type arguments. 
 * Now the compiler knows that the getSize() method can be found in the subtype of Fruit class (Apple, Orange etc.) 
 * because the Comparable<T> also receives our type(Fruit<T>) that contains the getSize() method.
 * This allows us to get rid of the repeated code of compareTo() method and also allows us to compare the fruits of the same types, 
 * apples with apples and oranges with oranges.
 * Now the compareTo() method can be used inside the max() function given in the question.
 */
public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple(3);
        Apple apple2 = new Apple(4);
        apple1.compareTo(apple2);

        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        orange1.compareTo(orange2);

//        apple1.compareTo(orange1);    // Error.
//                                      // 'compareTo(Apple)' in 'Fruit' cannot be applied to '(Orange)'
    }
}
