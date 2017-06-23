package chapter1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem14 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem14.replace(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNegativeTrueSize() {
        Problem14.replace("Mr John Smith    ", -9);
    }

    @Test
    public void testWithoutSpaces() {
        String replaced = Problem14.replace("MrJohnSmith", 11);
        assertNotNull(replaced);
        assertEquals("MrJohnSmith", replaced);
    }

    @Test
    public void testWithSample() {
        String replaced = Problem14.replace("Mr John Smith    ", 13);
        assertNotNull(replaced);
        assertEquals("Mr%20John%20Smith", replaced);
    }
}