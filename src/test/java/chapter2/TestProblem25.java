package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestProblem25 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem25.sum(null, null);
    }

    @Test
    public void testWithTwoNumbersSameSize() {
        Node<Integer> number1 = new Node<>(null);
        number1.setNext(new Node<>(7).setNext(new Node<>(1).setNext(new Node<>(6))));

        Node<Integer> number2 = new Node<>(null);
        number2.setNext(new Node<>(5).setNext(new Node<>(9).setNext(new Node<>(2))));

        Node<Integer> sum = Problem25.sum(number1, number2);
        assertNotNull(sum);
        assertEquals(Integer.valueOf(2), sum.getNext().getValue());
        assertEquals(Integer.valueOf(1), sum.getNext().getNext().getValue());
        assertEquals(Integer.valueOf(9), sum.getNext().getNext().getNext().getValue());
    }

    @Test
    public void testWithTwoNumbersDifferentSizes() {
        Node<Integer> number1 = new Node<>(null);
        number1.setNext(new Node<>(9).setNext(new Node<>(9)));

        Node<Integer> number2 = new Node<>(null);
        number2.setNext(new Node<>(9).setNext(new Node<>(9).setNext(new Node<>(9))));

        Node<Integer> sum = Problem25.sum(number1, number2);
        assertNotNull(sum);
        assertEquals(Integer.valueOf(8), sum.getNext().getValue());
        assertEquals(Integer.valueOf(9), sum.getNext().getNext().getValue());
        assertEquals(Integer.valueOf(0), sum.getNext().getNext().getNext().getValue());
        assertEquals(Integer.valueOf(1), sum.getNext().getNext().getNext().getNext().getValue());
    }
}