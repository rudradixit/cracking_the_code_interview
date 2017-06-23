package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem12 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem12.reverse(null);
    }

    @Test
    public void testWithEmpty() {
        assertEquals("", Problem12.reverse(""));
    }

    @Test
    public void testWithOneChar() {
        assertEquals("z", Problem12.reverse("z"));
    }

    @Test
    public void testWithMultipleChars() {
        assertEquals("fedcba", Problem12.reverse("abcdef"));
    }

    @Test
    public void testWithSpecialChars() {
        assertEquals("字漢)(*&^%$#@!", Problem12.reverse("!@#$%^&*()漢字"));
    }
}