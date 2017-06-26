package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem15 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem15.compress(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmpty() {
        Problem15.compress("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithInvalidChars() {
        Problem15.compress(" asdff908fadsf ");
    }

    @Test
    public void testWithCompressedOutput() {
        String input = "aabcccccaa";
        String output = "a2b1c5a2";
        String compressed = Problem15.compress(input);
        assertNotNull(compressed);
        assertNotEquals(input, compressed);
        assertEquals(output, compressed);
    }

    @Test
    public void testWithUncompressedOutput() {
        String input = "abcde";
        String output = "a1b1c1d1e1";
        String compressed = Problem15.compress(input);
        assertNotNull(compressed);
        assertNotEquals(output, compressed);
        assertEquals(input, compressed);
    }
}