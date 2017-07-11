package chapter9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem91 {
    @Test
    public void testWith1Step() {
        assertEquals(1, Problem91.run(1));
        assertEquals(1, Problem91_Improved.run(1));
    }

    @Test
    public void testWith2Steps() {
        assertEquals(2, Problem91.run(2));
        assertEquals(2, Problem91_Improved.run(2));
    }

    @Test
    public void testWith3Steps() {
        assertEquals(4, Problem91.run(3));
        assertEquals(4, Problem91_Improved.run(3));
    }

    @Test
    public void testWith5Steps() {
        assertEquals(13, Problem91.run(5));
        assertEquals(13, Problem91_Improved.run(5));
    }
}