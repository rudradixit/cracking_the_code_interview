package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestProblem43 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem43.treeify(null, 0, 0);
    }

    @Test
    public void testWithOneElement() {
        Integer[] array = new Integer[]{1};
        BinaryNode<Integer> node = Problem43.treeify(array, 0, array.length - 1);
        assertNotNull(node);
        assertEquals(array[0], node.getValue());
        assertNull(node.getLeft());
        assertNull(node.getRight());
    }

    @Test
    public void testWithTwoElements() {
        Integer[] array = new Integer[]{1, 2};
        BinaryNode<Integer> node = Problem43.treeify(array, 0, array.length - 1);
        assertNotNull(node);
        assertEquals(array[1], node.getValue());
        assertNotNull(node.getLeft());
        assertNull(node.getLeft().getLeft());
        assertNull(node.getLeft().getRight());
        assertEquals(array[0], node.getLeft().getValue());
        assertNull(node.getRight());
    }

    @Test
    public void testWithThreeElements() {
        Integer[] array = new Integer[]{1, 2, 3};
        BinaryNode<Integer> node = Problem43.treeify(array, 0, array.length - 1);
        assertNotNull(node);
        assertEquals(array[1], node.getValue());
        assertNotNull(node.getLeft());
        assertEquals(array[0], node.getLeft().getValue());
        assertNull(node.getLeft().getLeft());
        assertNull(node.getLeft().getRight());
        assertNotNull(node.getRight());
        assertEquals(array[2], node.getRight().getValue());
        assertNull(node.getRight().getLeft());
        assertNull(node.getRight().getRight());
    }
}