package chapter2;

import chapter2.aux.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestProblem27 {
    @Test(expected = IllegalArgumentException.class)
    public void testWithNull() {
        Problem27.isPalindrome(null);
    }

    @Test
    public void testWithEmpty() {
        Node<Integer> sentinel = new Node<>(null);
        assertTrue(Problem27.isPalindrome(sentinel));
    }

    @Test
    public void testOneElementEmpty() {
        Node<Integer> sentinel = new Node<Integer>(null).setNext(new Node<>(10));
        assertTrue(Problem27.isPalindrome(sentinel));
    }

    @Test
    public void testValidPalindrome() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(1);
        Node<Integer> sentinel = new Node<>(null);
        sentinel.setNext(
            node1.setNext(
                node2.setNext(
                    node3.setNext(node4)
                )
            )
        );
        assertTrue(Problem27.isPalindrome(sentinel));
    }

    @Test
    public void testInvalidPalindrome() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(1);
        Node<Integer> node4 = new Node<>(2);
        Node<Integer> sentinel = new Node<>(null);
        sentinel.setNext(
            node1.setNext(
                node2.setNext(
                    node3.setNext(node4)
                )
            )
        );
        assertFalse(Problem27.isPalindrome(sentinel));
    }
}