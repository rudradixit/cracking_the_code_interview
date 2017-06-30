package chapter4;

import chapter4.aux.BinaryNode;
import chapter4.aux.Traversals;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTraversals {
    @Test
    public void testPreOrderWithNull() {
        BinaryNode<Integer> node = null;
        final AtomicInteger accumulator = new AtomicInteger();

        Traversals.preOrder(node, binaryNode -> {
            accumulator.incrementAndGet();
            return null;
        });

        assertTrue(accumulator.get() == 0);
    }

    @Test
    public void testPreOrderWithTree() {
        BinaryNode<String> root = new BinaryNode<>("A");
        BinaryNode<String> level1LeftChild = new BinaryNode<>("B");
        BinaryNode<String> level1RightChild = new BinaryNode<>("C");
        BinaryNode<String> level2LeftChild = new BinaryNode<>("D");
        BinaryNode<String> level2RightChild = new BinaryNode<>("E");
        BinaryNode<String> level3LeftChild = new BinaryNode<>("F");
        BinaryNode<String> level3RightChild = new BinaryNode<>("G");
        root.setLeft(level1LeftChild);
        root.setRight(level1RightChild);
        level1LeftChild.setLeft(level2LeftChild);
        level1LeftChild.setRight(level2RightChild);
        level2LeftChild.setLeft(level3LeftChild);
        level2LeftChild.setRight(level3RightChild);
        final StringBuilder string = new StringBuilder();

        Traversals.preOrder(root, binaryNode -> {
            string.append(binaryNode.getValue());
            return null;
        });

        assertEquals("ABDFGEC", string.toString());
    }

    @Test
    public void testInOrderWithNull() {
        BinaryNode<Integer> node = null;
        final AtomicInteger accumulator = new AtomicInteger();

        Traversals.inOrder(node, binaryNode -> {
            accumulator.incrementAndGet();
            return null;
        });

        assertTrue(accumulator.get() == 0);
    }

    @Test
    public void testInOrderWithTree() {
        BinaryNode<String> root = new BinaryNode<>("A");
        BinaryNode<String> level1LeftChild = new BinaryNode<>("B");
        BinaryNode<String> level1RightChild = new BinaryNode<>("C");
        BinaryNode<String> level2LeftChild = new BinaryNode<>("D");
        BinaryNode<String> level2RightChild = new BinaryNode<>("E");
        BinaryNode<String> level3LeftChild = new BinaryNode<>("F");
        BinaryNode<String> level3RightChild = new BinaryNode<>("G");
        root.setLeft(level1LeftChild);
        root.setRight(level1RightChild);
        level1LeftChild.setLeft(level2LeftChild);
        level1LeftChild.setRight(level2RightChild);
        level2LeftChild.setLeft(level3LeftChild);
        level2LeftChild.setRight(level3RightChild);
        final StringBuilder string = new StringBuilder();

        Traversals.inOrder(root, binaryNode -> {
            string.append(binaryNode.getValue());
            return null;
        });

        assertEquals("FDGBEAC", string.toString());
    }

    @Test
    public void testPostOrderWithNull() {
        BinaryNode<Integer> node = null;
        final AtomicInteger accumulator = new AtomicInteger();

        Traversals.postOrder(node, binaryNode -> {
            accumulator.incrementAndGet();
            return null;
        });

        assertTrue(accumulator.get() == 0);
    }

    @Test
    public void testPostOrderWithTree() {
        BinaryNode<String> root = new BinaryNode<>("A");
        BinaryNode<String> level1LeftChild = new BinaryNode<>("B");
        BinaryNode<String> level1RightChild = new BinaryNode<>("C");
        BinaryNode<String> level2LeftChild = new BinaryNode<>("D");
        BinaryNode<String> level2RightChild = new BinaryNode<>("E");
        BinaryNode<String> level3LeftChild = new BinaryNode<>("F");
        BinaryNode<String> level3RightChild = new BinaryNode<>("G");
        root.setLeft(level1LeftChild);
        root.setRight(level1RightChild);
        level1LeftChild.setLeft(level2LeftChild);
        level1LeftChild.setRight(level2RightChild);
        level2LeftChild.setLeft(level3LeftChild);
        level2LeftChild.setRight(level3RightChild);
        final StringBuilder string = new StringBuilder();

        Traversals.postOrder(root, binaryNode -> {
            string.append(binaryNode.getValue());
            return null;
        });

        assertEquals("FGDEBCA", string.toString());
    }

    @Test
    public void testBreadthFirstWithNull() {
        BinaryNode<Integer> node = null;
        final AtomicInteger accumulator = new AtomicInteger();

        Traversals.breadthFirst(node, binaryNode -> {
            accumulator.incrementAndGet();
            return null;
        });

        assertTrue(accumulator.get() == 0);
    }

    @Test
    public void testBreadthFirstWithTree() {
        BinaryNode<String> root = new BinaryNode<>("A");
        BinaryNode<String> level1LeftChild = new BinaryNode<>("B");
        BinaryNode<String> level1RightChild = new BinaryNode<>("C");
        BinaryNode<String> level2LeftChild = new BinaryNode<>("D");
        BinaryNode<String> level2RightChild = new BinaryNode<>("E");
        BinaryNode<String> level3LeftChild = new BinaryNode<>("F");
        BinaryNode<String> level3RightChild = new BinaryNode<>("G");
        root.setLeft(level1LeftChild);
        root.setRight(level1RightChild);
        level1LeftChild.setLeft(level2LeftChild);
        level1LeftChild.setRight(level2RightChild);
        level2LeftChild.setLeft(level3LeftChild);
        level2LeftChild.setRight(level3RightChild);
        final StringBuilder string = new StringBuilder();

        Traversals.breadthFirst(root, binaryNode -> {
            string.append(binaryNode.getValue());
            return null;
        });

        assertEquals("ABCDEFG", string.toString());
    }
}