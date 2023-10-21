package chapter8;

public class ExceptionEx1 {
    public static void main(String[] args) {
        try {
            try { } catch (Exception e1) {}
        } catch (Exception e2) {
            try {} catch (Exception e3) {}
        }

        try {

        } catch (Exception e1) {
            // do something.
        }
    }
}
