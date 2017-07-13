package chapter9;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblem96 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNegative() {
        Problem96.parentheses(-1);
    }

    @Test
    public void testWithOnePair() {
        Set<String> set = Problem96.parentheses(1);
        assertEquals(1, set.size());
        assertTrue(set.contains("()"));
    }

    @Test
    public void testWithTwoPairs() {
        Set<String> set = Problem96.parentheses(2);
        assertEquals(2, set.size());
        assertTrue(set.contains("()()"));
        assertTrue(set.contains("(())"));
    }

    @Test
    public void testWithThreePairs() {
        Set<String> set = Problem96.parentheses(3);
        assertEquals(5, set.size());
        assertTrue(set.contains("((()))"));
        assertTrue(set.contains("(()())"));
        assertTrue(set.contains("(())()"));
        assertTrue(set.contains("()(())"));
        assertTrue(set.contains("()()()"));
    }
}