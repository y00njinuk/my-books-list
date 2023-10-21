package chapter2.item6;

// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    // TODO. 실제로 인스턴스가 생성이 많이 되고 있는지 VisualVM을 활용하여 Heap 덤프해보기
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}