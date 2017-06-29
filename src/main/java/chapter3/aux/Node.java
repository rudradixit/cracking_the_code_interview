package chapter3.aux;

public class Node<T> {
    private T value;
    private Node<T> next;
    
    public Node(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }
    
    public Node<T> getNext() {
        return next;
    }
    
    @Override
    public int hashCode() {
        int result = 37;
        result = 31 * result + ((value == null) ? 0 : value.hashCode());
        result = 31 * result + ((next == null) ? 0 : next.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        if (this == other) {
            return true;
        }
        
        if (!(other instanceof Node)) {
            return false;
        }
        
        Node<T> otherNode = (Node<T>)other;

        if (value == null && otherNode.value != null) {
            return false;
        }

        if (value != null && otherNode.value == null) {
            return false;
        }

        if (next == null && otherNode.next != null) {
            return false;
        }

        if (next != null && otherNode.next == null) {
            return false;
        }

        return (value == null && otherNode.value == null) ? true : value.equals(otherNode.value) &&
               (next == null && otherNode.next == null) ? true : next.equals(otherNode.next);
    }
    
    @Override
    public String toString() {
        return (value == null) ? "N/A" : value.toString();
    }
}