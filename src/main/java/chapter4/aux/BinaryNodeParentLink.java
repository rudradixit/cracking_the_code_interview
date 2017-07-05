package chapter4.aux;

public class BinaryNodeParentLink<T> extends BinaryNode<T> {
    private BinaryNodeParentLink<T> parent;

    public BinaryNodeParentLink(T value) {
        super(value);
    }

    @Override
    public BinaryNode<T> setLeft(BinaryNode<T> left) {
        BinaryNodeParentLink<T> leftWithLink = (BinaryNodeParentLink)left;
        super.setLeft(leftWithLink);
        leftWithLink.parent = this;
        return this;
    }

    @Override
    public BinaryNode<T> setRight(BinaryNode<T> right) {
        BinaryNodeParentLink<T> rightWithLink = (BinaryNodeParentLink)right;
        super.setRight(rightWithLink);
        rightWithLink.parent = this;
        return this;
    }

    public BinaryNodeParentLink<T> getParent() {
        return parent;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * ((parent == null) ? 0 : parent.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        boolean equals = super.equals(object);

        if (!equals) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        BinaryNodeParentLink<T> other = (BinaryNodeParentLink<T>)object;

        if (parent != null) {
            equals = parent.equals(other.parent);
        }

        return equals;
    }
}