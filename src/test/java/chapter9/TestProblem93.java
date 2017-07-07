package chapter9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestProblem93 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem93.findMagicIndex(null);
    }

    @Test
    public void testWithMagicIndexInTheBeginning() {
        int[] array = {0, 5, 6, 7};
        assertEquals(Integer.valueOf(0), Problem93.findMagicIndex(array));
    }

    @Test
    public void testWithMagicIndexAtTheEnd() {
        int[] array = {-17, -3, 1, 3};
        assertEquals(Integer.valueOf(3), Problem93.findMagicIndex(array));
    }

    @Test
    public void testWithNoMagicIndex() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertNull(Problem93.findMagicIndex(array));
    }
}