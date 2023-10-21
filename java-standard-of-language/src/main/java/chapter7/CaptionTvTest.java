package chapter7;

public class CaptionTvTest {
    static class Tv {
        boolean power;      // default: false
        int channel;        // default: 0

        void power() { power = !power; }
        void channelUp() { ++channel; }
        void channelDown() { --channel; }
    }

    static class CaptionTv extends Tv {
        boolean caption;    // default: false
        void displayCaption(String text) {
            if(caption) {
                System.out.println(text);
            }
        }
    }

    public static void main(String[] args) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
        ctv.displayCaption("Hello World 1");
        ctv.caption = true;
        ctv.displayCaption("Hello World 2");
    }
}
