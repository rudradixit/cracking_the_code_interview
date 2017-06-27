package chapter3.aux;

import java.util.Optional;

public class SingleStack<T> implements Stack<T> {
    private Node<T> top = new Node<>(null);
    
    @Override
    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Invalid value!");
        }
        
        Node<T> node = new Node<>(value);
        node.setNext(top.getNext());
        top.setNext(node);
    }

    @Override
    public Optional<T> pop() {
        Node<T> first = top.getNext();        
        
        if (first != null) {
            top.setNext(first.getNext());
            first.setNext(null);
            return Optional.of(first.getValue());
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<T> peek() {
        Node<T> first = top.getNext();        
        
        if (first != null) {
            return Optional.of(first.getValue());
        }
        
        return Optional.empty();
    }

    @Override
    public int size() {
        int size = 0;
        Node<T> walker = top.getNext();
        
        while (walker != null) {
            size++;
            walker = walker.getNext();
        }
        
        return size;
    }
}