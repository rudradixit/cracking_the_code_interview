package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem41 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem41.isBalanced(null);
    }

    @Test
    public void testWithOneElementTree() {
        assertTrue(Problem41.isBalanced(new BinaryNode<>(1)));
    }

    @Test
    public void testWithTwoElementsTree() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        root.setLeft(new BinaryNode<>(2));
        assertTrue(Problem41.isBalanced(root));
    }

    @Test
    public void testWithThreeElementsTree() {
        BinaryNode<String> root = new BinaryNode<>("a");
        root.setLeft(new BinaryNode<>("b"));
        root.setRight(new BinaryNode<>("c"));
        assertTrue(Problem41.isBalanced(root));
    }

    @Test
    public void testWithFullTree() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> level1LeftChild = new BinaryNode<>(2);
        BinaryNode<Integer> level1RightChild = new BinaryNode<>(3);
        BinaryNode<Integer> level2LeftChild = new BinaryNode<>(4);
        BinaryNode<Integer> level2RightChild = new BinaryNode<>(5);
        BinaryNode<Integer> level3LeftChild = new BinaryNode<>(6);
        BinaryNode<Integer> level3RightChild = new BinaryNode<>(7);
        root.setLeft(level1LeftChild);
        root.setRight(level1RightChild);
        level1LeftChild.setLeft(level2LeftChild);
        level1LeftChild.setRight(level2RightChild);
        level2LeftChild.setLeft(level3LeftChild);
        level2LeftChild.setRight(level3RightChild);
        assertFalse(Problem41.isBalanced(root));
    }
}