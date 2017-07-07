package chapter4.aux;

public class TernaryNode<T> {
    private T value;
    private TernaryNode<T> left;
    private TernaryNode<T> middle;
    private TernaryNode<T> right;

    public TernaryNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TernaryNode<T> setChild(int index, TernaryNode<T> child) {
        switch (index) {
            case 1 : setLeft(child); break;
            case 2 : setMiddle(child); break;
            case 3 : setRight(child); break;
        }

        return this;
    }

    public TernaryNode<T> getChild(int index) {
        switch (index) {
            case 1 : return getLeft();
            case 2 : return getMiddle();
            case 3 : return getRight();
            default: throw new IllegalArgumentException("Invalid index!");
        }
    }

    public TernaryNode<T> getLeft() {
        return left;
    }

    public TernaryNode<T> setLeft(TernaryNode<T> left) {
        this.left = left;
        return this;
    }
    
    public TernaryNode<T> getMiddle() {
        return middle;
    }

    public TernaryNode<T> setMiddle(TernaryNode<T> middle) {
        this.middle = middle;
        return this;
    }

    public TernaryNode<T> getRight() {
        return right;
    }

    public TernaryNode<T> setRight(TernaryNode<T> right) {
        this.right = right;
        return this;
    }

    public boolean isLeaf() {
        return left == null && middle == null && right == null;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * ((value == null) ? 0 : value.hashCode());
        result += 31 * ((left == null) ? 0 : left.hashCode());
        result += 31 * ((middle == null) ? 0 : middle.hashCode());
        result += 31 * ((right == null) ? 0 : right.hashCode());
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

        TernaryNode<T> other = (TernaryNode<T>)object;
        boolean equals = true;

        if (value != null) {
            equals = value.equals(other.value);
        }

        if (left != null) {
            equals = equals && left.equals(other.left);
        }
        
        if (middle != null) {
            equals = equals && middle.equals(other.middle);
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