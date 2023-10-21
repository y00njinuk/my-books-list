package chapter7;

public class InnerEx3 {
    private int outerIv = 0;
    static int outerCv = 0;

    class InstanceInner {
        int iiv = outerIv;
        int iiv2 = outerCv;
        // 'static' is not allowed in InstanceInner.
    }

    static class StaticInner {
//        int siv = outerIv;          // compile error.
        int siv2 = outerCv;
//        static int ssv = outerIv;   // compile error.
        static int ssv2 = outerCv;
    }

    void localMethod() {
        int lv = 0;
        final int LV = 0;

        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
            int liv3 = lv;
            int liv4 = LV;
            // 'static' is not allowed in LocalInner.
        }
    }
}