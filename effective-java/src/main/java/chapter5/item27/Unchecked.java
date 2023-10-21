package chapter5.item27;

import java.util.TreeSet;

public class Unchecked {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add("abc");             // unchecked warning
        set.remove("abc");
    }
}
