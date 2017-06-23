package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem11 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNullForUniqueCharsWithAdditionalDS() {
        Problem11.verifyUniqueCharsWithAdditionalDS(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullForUniqueCharsWithoutAdditionalDS() {
        Problem11.verifyUniqueCharsWithAdditionalDS(null);
    }

    @Test
    public void testWithEmptyForUniqueCharsWithAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS(""));
    }

    @Test
    public void testWithEmptyForUniqueCharsWithoutAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS(""));
    }

    @Test
    public void testWithOneCharForUniqueCharsWithAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS(""));
    }

    @Test
    public void testWithOneCharForUniqueCharsWithoutAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS(""));
    }

    @Test
    public void testWithDuplicateForUniqueCharsWithAdditionalDS() {
        assertFalse(Problem11.verifyUniqueCharsWithAdditionalDS("abcda"));
    }

    @Test
    public void testWithDuplicateForUniqueCharsWithoutAdditionalDS() {
        assertFalse(Problem11.verifyUniqueCharsWithAdditionalDS("abcda"));
    }

    @Test
    public void testWithUniqueForUniqueCharsWithAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS("abcdef"));
    }

    @Test
    public void testWithUniqueForUniqueCharsWithoutAdditionalDS() {
        assertTrue(Problem11.verifyUniqueCharsWithAdditionalDS("abcdef"));
    }
}