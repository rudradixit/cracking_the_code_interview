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

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof SingleStack)) {
            return false;
        }

        if (this == object) {
            return true;
        }

        SingleStack<T> other = (SingleStack<T>) object;

        if (size() != other.size()) {
            return false;
        }

        Node<T> n1 = top.getNext(), n2 = other.top.getNext();

        for (int i=1; i<size(); i++) {
            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null) {
                return false;
            }

            if (n2 == null) {
                return false;
            }

            if (!n1.equals(n2)) {
                return false;
            }

            n1 = n1.getNext();
            n2 = n2.getNext();
        }

        return true;
    }

    @Override
    public String toString() {
        Node<T> walker = top.getNext();
        StringBuilder builder = new StringBuilder("[");

        while (walker != null) {
            builder.append(walker.getValue()).append(",");
            walker = walker.getNext();
        }

        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append("]");
        return builder.toString();
    }
}