package chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem34 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNegative() {
        Problem34.solveTowerOfHanoi(-1);
    }

    @Test
    public void testWithOneDisk() {
        List<String> expectedSteps = new ArrayList<String>() {{
           add("move disk from tower A to tower C");
        }};
        List<String> steps = Problem34.solveTowerOfHanoi(1);
        assertNotNull(steps);
        assertEquals(expectedSteps, steps);
    }

    @Test
    public void testWithTwoDisks() {
        List<String> expectedSteps = new ArrayList<String>() {{
            add("move disk from tower A to tower B");
            add("move disk from tower A to tower C");
            add("move disk from tower B to tower C");
        }};
        List<String> steps = Problem34.solveTowerOfHanoi(2);
        assertNotNull(steps);
        assertEquals(expectedSteps, steps);
    }

    @Test
    public void testWithThreeDisks() {
        List<String> expectedSteps = new ArrayList<String>() {{
            add("move disk from tower A to tower C");
            add("move disk from tower A to tower B");
            add("move disk from tower C to tower B");
            add("move disk from tower A to tower C");
            add("move disk from tower B to tower A");
            add("move disk from tower B to tower C");
            add("move disk from tower A to tower C");
        }};
        List<String> steps = Problem34.solveTowerOfHanoi(3);
        assertNotNull(steps);
        assertEquals(expectedSteps, steps);
    }
}