package chapter5.item28;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        Chooser intChooser = new Chooser(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = (Number) intChooser.choose();
            System.out.println(choice);
        }

        List<String> strList = List.of("a", "b", "c", "d", "e");
        Chooser strChooser = new Chooser(strList);

        for (int i = 0; i < 10; i++) {
            String choice = (String) strChooser.choose();
            System.out.println(choice);
        }
    }
}
