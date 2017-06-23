package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem13 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNulls() {
        Problem13.verifyPermutation(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullFirstParam() {
        Problem13.verifyPermutation(null, "abcdef");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullSecondParam() {
        Problem13.verifyPermutation("abcdef", null);
    }

    @Test
    public void testTrueWithOneChar() {
        assertTrue(Problem13.verifyPermutation("a", "a"));
    }

    @Test
    public void testTrueWithMultipleChars() {
        assertTrue(Problem13.verifyPermutation("abcdef", "fedcba"));
    }

    @Test
    public void testFalseWithOneChar() {
        assertFalse(Problem13.verifyPermutation("a", "b"));
    }

    @Test
    public void testFalseWithMultipleChars() {
        assertFalse(Problem13.verifyPermutation("abcdef", "fgdcba"));
    }
}