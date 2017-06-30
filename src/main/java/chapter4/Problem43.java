package chapter4;

import chapter4.aux.BinaryNode;

public class Problem43 {
    public static <T> BinaryNode<T> treeify(T[] array, int start, int end) {
        if (array == null || start < 0 || end >= array.length) {
            throw new IllegalArgumentException("Invalid paramters!");
        }

        if (end - start == 0) {
            return new BinaryNode<>(array[start]);
        }

        BinaryNode<T> root;

        if (end - start == 1) {
            root = new BinaryNode<>(array[end]);
            root.setLeft(new BinaryNode<>(array[start]));
        } else {
            int mid = (end - start) / 2;
            root = new BinaryNode<>(array[mid]);
            root.setLeft(treeify(array, start, mid - 1));
            root.setRight(treeify(array, mid + 1, end));
        }

        return root;
    }
}