package chapter4.aux;

public class BinaryNode<T> {
    protected T value;
    protected BinaryNode<T> left;
    protected BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
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
    public int hashCode() {
        int result = 17;
        result = 31 * ((value == null) ? 0 : value.hashCode());
        result = 31 * ((left == null) ? 0 : left.hashCode());
        result = 31 * ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        BinaryNode<T> other = (BinaryNode<T>)object;
        boolean equals = true;

        if (value != null) {
            equals = value.equals(other.value);
        }

        if (left != null) {
            equals = equals && left.equals(other.left);
        }

        if (right != null) {
            equals = equals && right.equals(other.right);
        }

        return equals;
    }

    @Override
    public String toString() {
        return (value == null) ? "N/A" : value.toString();
    }
}