package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem21 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem21.removeDuplicates(null);
    }

    @Test
    public void testWithEmpty() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> updatedSentinel = Problem21.removeDuplicates(sentinel);

        assertNotNull(updatedSentinel);
        assertEquals(sentinel, updatedSentinel);
    }

    @Test
    public void testWithOneElement() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        sentinel.setNext(new Node<>(1));
        Node<Integer> updatedSentinel = Problem21.removeDuplicates(sentinel);

        assertNotNull(updatedSentinel);
        assertEquals(sentinel, updatedSentinel);
    }

    @Test
    public void testWithTwoDistinctElements() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> node1 = new Node<>(1);
        sentinel.setNext(node1);
        Node<Integer> node2 = new Node<>(2);
        node1.setNext(node2);
        Node<Integer> updatedSentinel = Problem21.removeDuplicates(sentinel);

        assertNotNull(updatedSentinel);
        assertEquals(sentinel, updatedSentinel);
    }

    @Test
    public void testWithTwoDuplicateElements() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> node1 = new Node<>(1);
        sentinel.setNext(node1);
        Node<Integer> node2 = new Node<>(1);
        node1.setNext(node2);
        Node<Integer> updatedSentinel = Problem21.removeDuplicates(sentinel);

        Node<Integer> outputSentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> outputNode1 = new Node<>(1);
        outputSentinel.setNext(outputNode1);

        assertNotNull(updatedSentinel);
        assertEquals(outputSentinel, updatedSentinel);
    }
}