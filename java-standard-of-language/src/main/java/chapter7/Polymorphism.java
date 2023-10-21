package chapter7;

public class Polymorphism {
    static class Tv {
        boolean power;
        int channel;

        void power() { power = !power; }
        void channelUp() { ++channel; }
        void channelDown() { --channel; }
    }

    static class CaptionTv extends Tv {
        String text;
        void caption() {
            // do something.
        }
    }

    public static void main(String[] args) {
        CaptionTv c = new CaptionTv();
        Tv t = new CaptionTv();
        CaptionTv a = (CaptionTv) new Tv();
    }
}
