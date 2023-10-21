package chapter5;

public class ArrayEx {
    public static void main(String[] args) {
        int[] arrayInt = new int[5];   // init
        String[] arrayString = new String[5];

        System.out.println(arrayInt);
        // [I@1b6d3586 (타입@주소)
        // "[I"       -> 1차원 int 배열
        // "1b6d3586" -> 16진수 배열의 주소
        for(int i=0; i<arrayInt.length; i++) {
            System.out.println(arrayInt[i]); // default: 0
        }

        System.out.println(arrayString);
        for(int i=0; i<arrayString.length; i++) {
            System.out.println(arrayString[i]); // default: null
        }
    }
}
