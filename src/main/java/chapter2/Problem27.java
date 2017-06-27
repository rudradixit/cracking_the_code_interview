package chapter2;

import chapter2.aux.Node;

public class Problem27 {
    public static <T> boolean isPalindrome(Node<T> sentinel) {
        if (sentinel == null) {
            throw new IllegalArgumentException("Invalid list!");
        }
        
        if (sentinel.getNext() == null || sentinel.getNext().getNext() == null) {
            return true;
        }
        
        Node<T> head = sentinel;
        Node<T> tail;
        Node<T> aux = null;
        
        while (head != aux) {
            head = head.getNext();
            tail = head;

            while (tail != aux && tail.getNext() != aux) {
                tail = tail.getNext();
            }

            if (!head.getValue().equals(tail.getValue())) {
                return false;
            }

            aux = tail;
        }
        
        return true;
    }
}