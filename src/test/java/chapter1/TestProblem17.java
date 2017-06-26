package chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem17 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem17.crossout(null);
    }

    @Test
    public void testNoChanges() {
        int[][] input = new int[][] {
                {1, 2},
                {3, 4}
        };

        int[][] crossedOut = Problem17.crossout(input);
        assertNotNull(crossedOut);
        assertArrayEquals(input, crossedOut);
    }

    @Test
    public void testWith2By2Array() {
        int[][] input = new int[][] {
            {1, 0},
            {3, 4}
        };

        int[][] output = new int[][] {
            {0, 0},
            {3, 0}
        };

        int[][] crossedOut = Problem17.crossout(input);
        assertNotNull(crossedOut);
        assertArrayEquals(output, crossedOut);
    }

    @Test
    public void testWith3By3Array() {
        int[][] input = new int[][] {
                {0, 2, 3},
                {4, 0, 6},
                {7, 8, 0},
        };

        int[][] output = new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        int[][] crossedOut = Problem17.crossout(input);
        assertNotNull(crossedOut);
        assertArrayEquals(output, crossedOut);
    }
}