package chapter4;

import chapter4.aux.BinaryNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem45 {
    @Test
    public void testWithOneElement() {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        assertTrue(Problem45.isBinarySearchTree(root));
    }

    @Test
    public void testWithTwoElementsValidBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        root.setLeft(new BinaryNode<>(5));
        assertTrue(Problem45.isBinarySearchTree(root));
    }

    @Test
    public void testWithTwoElementsInvalidBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        root.setLeft(new BinaryNode<>(15));
        assertFalse(Problem45.isBinarySearchTree(root));
    }

    @Test
    public void testWithThreeElementsValidBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        root.setLeft(new BinaryNode<>(5));
        root.setRight(new BinaryNode<>(15));
        assertTrue(Problem45.isBinarySearchTree(root));
    }

    @Test
    public void testWithThreeElementsInvalidBinarySearchTree() {
        BinaryNode<Integer> root = new BinaryNode<>(10);
        root.setLeft(new BinaryNode<>(9));
        root.setRight(new BinaryNode<>(8));
        assertFalse(Problem45.isBinarySearchTree(root));
    }
}