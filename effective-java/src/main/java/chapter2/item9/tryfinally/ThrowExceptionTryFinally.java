package chapter2.item9.tryfinally;

import java.io.IOException;

public class ThrowExceptionTryFinally {
    static void doSomething() throws IOException {
        try {
            throw new IOException("exception in try block");
        } finally {
            throw new IOException("exception in finally block");
        }
    }

    public static void main(String[] args) throws IOException {
        doSomething();
    }
}
