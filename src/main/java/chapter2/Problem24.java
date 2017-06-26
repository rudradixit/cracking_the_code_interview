package chapter2;

import chapter2.aux.Node;

import java.util.ArrayList;
import java.util.List;

public class Problem24 {
    public static <T extends Comparable> List<Node<T>> partition(Node<T> sentinel, T element) {
        if (sentinel == null) {
            throw new IllegalArgumentException("Invalid sentinel!");
        }
        
        if (element == null) {
            throw new IllegalArgumentException("Invalid element!");
        }
        
        Node<T> walker = sentinel.getNext();
        Node<T> lowerSentinel = new Node<>(null);
        Node<T> lowerNode = lowerSentinel;
        Node<T> greaterSentinel = new Node<>(null);
        Node<T> greaterNode = greaterSentinel;
        Node<T> node;
        
        while (walker != null) {
            node = new Node<>(walker.getValue());

            if (walker.getValue().compareTo(element) < 0) {
                lowerNode.setNext(node);
                lowerNode = lowerNode.getNext();
            } else {
                greaterNode.setNext(node);
                greaterNode = greaterNode.getNext();
            }
            
            walker = walker.getNext();
        }

        return new ArrayList<Node<T>>() {{ add(lowerSentinel); add(greaterSentinel); }};
    }
}