package chapter5;

public class ArrayEx18 {
    public static void main(String[] args) {
        int[][] score = {{100, 100, 100}, {20, 20, 20}, {30, 30, 30}, {40, 40, 40}};
        int sum;

        // 1. for iteration.
        sum = 0;
        for (int i = 0; i < score.length; i++)
            for (int j = 0; j < score[i].length; j++)
                sum += score[i][j];

        // 2. enhanced for iteration.
        sum = 0;
        for (int[] tmp : score)
            for (int i : tmp)
                sum += i;
    }
}
