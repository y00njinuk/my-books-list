package chapter7.item45.anagrams;

public class IntStreamToString {
    public static void main(String[] args) {
        String word = "test";

        String res = word
                .chars()
                .sorted()
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append)
                .toString();

        System.out.println(res);
    }
}
