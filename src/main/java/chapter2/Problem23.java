package chapter2;

import chapter2.aux.Node;

public class Problem23 {
    public static <T> void delete(Node<T> toBeDeleted) {
        if (toBeDeleted == null) {
            throw new IllegalArgumentException("Invalid node to be deleted!");
        }
        
        Node<T> next = toBeDeleted.getNext();
        toBeDeleted.setValue(next.getValue());
        toBeDeleted.setNext(next.getNext());
        next.setNext(null);
    }
}