package chapter2;

import chapter2.aux.Node;

public class Problem21 {
    public static <T> Node<T> removeDuplicates(Node<T> sentinel) {
        if (sentinel == null) {
            throw new IllegalArgumentException("Invalid sentinel!");
        }
        
        if (sentinel.getNext() == null || sentinel.getNext().getNext() == null) {
            return sentinel;
        }
        
        Node<T> slow = sentinel.getNext();
        Node<T> previous = sentinel.getNext();
        Node<T> fast = sentinel.getNext().getNext();
        
        while (fast != null) {
            if (slow.getValue().equals(fast.getValue())) {
                delete(previous);
                slow = slow.getNext();
                previous = slow;
                fast = (slow == null) ? null : slow.getNext();
            } else {
                previous = fast;
                fast = fast.getNext();
            }
        }
        
        return sentinel;
    }
    
    private static <T> void delete(Node<T> previous) {
        Node<T> toBeDeleted = previous.getNext();
        previous.setNext(toBeDeleted.getNext());
        toBeDeleted.setNext(null);
    }
}