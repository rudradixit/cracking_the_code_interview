package chapter4.aux;

public class BinaryNode<T> {
    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> setLeft(BinaryNode<T> left) {
        this.left = left;
        return this;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public BinaryNode<T> setRight(BinaryNode<T> right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        return (value == null) ? "N/A" : value.toString();
    }
}