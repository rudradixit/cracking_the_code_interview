package chapter9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem92 {
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidX() {
        Problem92.robotWalk(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidY() {
        Problem92.robotWalk(1, 0);
    }

    @Test
    public void testWith1By1() {
        assertEquals(2, Problem92.robotWalk(1, 1));
    }

    @Test
    public void testWith2By1() {
        assertEquals(3, Problem92.robotWalk(2, 1));
    }

    @Test
    public void testWith1By2() {
        assertEquals(3, Problem92.robotWalk(1, 2));
    }

    @Test
    public void testWith2By2() {
        assertEquals(6, Problem92.robotWalk(2, 2));
    }

    @Test
    public void testWith3By3() {
        assertEquals(20, Problem92.robotWalk(3, 3));
    }
}