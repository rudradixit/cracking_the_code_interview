package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TestProblem22 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem22.find(null, 1);
    }

    @Test
    public void testWithEmpty() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Optional<Node<Integer>> optional = Problem22.find(sentinel, 1);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testWithOneElementInBoundsK() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        sentinel.setNext(new Node<>(1));
        Optional<Node<Integer>> optional = Problem22.find(sentinel, 1);

        assertTrue(optional.isPresent());
        assertEquals(sentinel.getNext(), optional.get());
    }

    @Test
    public void testWithOneElementOutOfBoundsK() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        sentinel.setNext(new Node<>(1));
        Optional<Node<Integer>> optional = Problem22.find(sentinel, 10);

        assertFalse(optional.isPresent());
    }

    @Test
    public void testWithMultipleElementsInBoundsK() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> node = new Node<>(1);
        sentinel.setNext(node);
        Optional<Node<Integer>> optional = Problem22.find(sentinel, 1);

        assertTrue(optional.isPresent());
        assertEquals(sentinel.getNext(), optional.get());
    }

    @Test
    public void testWithMultipleElementsOutOfBoundsK() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        Node<Integer> node = new Node<>(1);
        sentinel.setNext(
            new Node<>(1).setNext(
                new Node<>(2).setNext(
                    new Node<>(3).setNext(
                        new Node<>(4).setNext(
                            new Node<>(5)
                        )
                    )
                )
            )
        );

        Optional<Node<Integer>> optional = Problem22.find(sentinel, 3);

        assertTrue(optional.isPresent());
        assertEquals(new Node<>(3), optional.get());
    }
}