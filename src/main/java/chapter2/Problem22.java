package chapter2;

import chapter2.aux.Node;

import java.util.Optional;

public class Problem22 {
    public static <T> Optional<Node<T>> find(Node<T> sentinel, int k) {
        if (sentinel == null) {
            throw new IllegalArgumentException("Invalid sentinel!");
        }
        
        if (k < 1) {
            throw new IllegalArgumentException("Invalid 'k' parameter!");
        }
        
        Node<T> slow = sentinel;
        Node<T> fast = sentinel;
        
        for (int i=0; i<k; i++) {
            fast = (fast == null) ? null : fast.getNext();
        }
        
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return (slow == sentinel) ? Optional.empty() : Optional.of(slow);
    }
}