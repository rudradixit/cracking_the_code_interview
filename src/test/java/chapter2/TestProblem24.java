package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestProblem24 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem24.partition(null, 4);
    }

    @Test
    public void testWithTwoElements() {
        Node<Integer> sentinel = new Node<>(null);
        sentinel.setNext(new Node<>(1).setNext(new Node<>(3)));

        List<Node<Integer>> list = Problem24.partition(sentinel, 2);
        assertNotNull(list);
        assertEquals(2, list.size());

        Node<Integer> lowerSentinel = list.get(0);
        assertNotNull(lowerSentinel.getNext());
        assertNull(lowerSentinel.getNext().getNext());
        assertEquals(Integer.valueOf(1), lowerSentinel.getNext().getValue());

        Node<Integer> greaterSentinel = list.get(1);
        assertNotNull(greaterSentinel.getNext());
        assertNull(greaterSentinel.getNext().getNext());
        assertEquals(Integer.valueOf(3), greaterSentinel.getNext().getValue());
    }
}