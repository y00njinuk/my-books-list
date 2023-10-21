package chapter3;

public class OperatorEx2 {
    public static void main(String[] args) {
        int i=5, j=0;

        j = i++;
        System.out.println("i = " + i + ", j = " + j);

        i=5;
        j=0;

        j = ++i;
        System.out.println("i = " + i + ", j = " + j);
    }

}
