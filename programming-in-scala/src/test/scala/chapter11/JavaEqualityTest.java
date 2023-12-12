package chapter11;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaEqualityTest {
    @Test
    public void referenceEqualityTest() {
        String str1 = new String("AnyRef");
        String str2 = new String("AnyRef");

        assertFalse(str1 == str2);
    }

    @Test
    public void referenceEqualityTestWithNullSafe() {
        // not null-safe
        String str3 = null;
        String str4 = null;

        assertTrue(str3 == str4);
    }

    @Test
    public void valueEqualityTest() {
        String str1 = new String("AnyRef");
        String str2 = new String("AnyRef");

        assertTrue(str1.equals(str2));
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void valueEqualityTestWithNotNullSafe() {
        // not null-safe
        String str3 = null;
        String str4 = null;

        assertTrue(str3.equals(str4));
    }
}
