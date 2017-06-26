package chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem18 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNullInput() {
        Problem18.isRotation(null, "sadfsadfsa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullExcerpt() {
        Problem18.isRotation("asdfsaf23easf", null);
    }

    @Test
    public void testWithSubstring() {
        String input = "waterbottle";
        String excerpt = "erbottlewat";
        assertTrue(Problem18.isRotation(input, excerpt));
    }

    @Test
    public void testWithoutSubstring() {
        String input = "dog";
        String excerpt = "cat";
        assertFalse(Problem18.isRotation(input, excerpt));
    }
}