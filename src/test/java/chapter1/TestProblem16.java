package chapter1;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem16 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem16.rotate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNonSquaredMatrix() {
        Problem16.rotate(
            new int[][] {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
            }
        );
    }

    @Test
    public void testWith2By2Array() {
        int[][] input = new int[][] {
            {1, 2},
            {3, 4}
        };

        int[][] output = new int[][] {
            {3, 1},
            {4, 2}
        };

        int[][] rotated = Problem16.rotate(input);
        assertNotNull(rotated);
        assertNotEquals(input, rotated);
        assertArrayEquals(output, rotated);
    }

    @Test
    public void testWith3By3Array() {
        int[][] input = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };

        int[][] output = new int[][] {
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3},
        };

        int[][] rotated = Problem16.rotate(input);
        assertNotNull(rotated);
        assertNotEquals(input, rotated);
        assertArrayEquals(output, rotated);
    }

    @Test
    public void testWith4By4Array() {
        int[][] input = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
        };

        int[][] output = new int[][] {
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4},
        };

        int[][] rotated = Problem16.rotate(input);
        assertNotNull(rotated);
        assertNotEquals(input, rotated);
        assertArrayEquals(output, rotated);
    }
}