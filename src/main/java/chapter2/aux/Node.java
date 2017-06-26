package chapter2.aux;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> setNext(Node<T> next) {
        this.next = next;
        return this;
    }

    @Override
    public int hashCode() {
        int result = 37;
        result += 31 * result + ((value == null) ? 0 : value.hashCode());
        result += 31 * result + ((next == null) ? 0 : next.hashCode());
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

        Node otherNode = (Node)other;
        return value.equals(otherNode.value);
    }

    @Override
    public String toString() {
        return (value == null) ? "N/A" : value.toString();
    }
}