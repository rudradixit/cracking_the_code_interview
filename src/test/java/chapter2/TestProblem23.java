package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem23 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem23.delete(null);
    }

    @Test
    public void testWithThreeElements() {
        Node<Integer> sentinel = new Node<>(-Integer.MIN_VALUE);
        sentinel.setNext(new Node<>(1).setNext(new Node<>(2).setNext(new Node<>(3))));
        Problem23.delete(sentinel.getNext().getNext());

        assertNotNull(sentinel);
        assertNotNull(sentinel.getNext());
        assertEquals(new Node<>(1), sentinel.getNext());
        assertNotNull(sentinel.getNext().getNext());
        assertEquals(new Node<>(3), sentinel.getNext().getNext());
    }
}