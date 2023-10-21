package chapter14;

public class LambdaEx2 {
    @FunctionalInterface
    interface MyFunction {
        void myMethod();     // public abstract void run();
    }

    public static void main(String[] args) {
        MyFunction f = ()->{};
        Object obj = (MyFunction)(()->{});
        String str = ((Object)(MyFunction)(()->{})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

//        System.out.println(()->{}); // error
        System.out.println((MyFunction)(()->{}));
//        System.out.println((MyFunction)(()->{}).toString()); // error
        System.out.println(((Object)(MyFunction)(()->{})).toString());

    }
}
