package chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// List-based Chooser - typesafe (Page 129)
public class GChooser<T> {
    private final List<T> choiceList;

    public GChooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
        GChooser<Integer> intGChooser = new GChooser<>(intList);

        for (int i = 0; i < 10; i++) {
            Number choice = intGChooser.choose();
            System.out.println(choice);
        }

        List<String> strList = List.of("a", "b", "c", "d", "e");
        GChooser<String> strGChooser = new GChooser<>(strList);

        for (int i = 0; i < 10; i++) {
            String choice = strGChooser.choose();
            System.out.println(choice);
        }
    }
}
