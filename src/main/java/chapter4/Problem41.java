package chapter4;

import chapter4.aux.BinaryNode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Problem41 {
    public static <T> boolean isBalanced(BinaryNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("Invalid root!");
        }

        return abs(getHeight(root.getLeft()) - getHeight(root.getRight())) <= 1;
    }

    private static <T> int getHeight(BinaryNode<T> root) {
        if (root == null) {
            return 0;
        }

        int heightSubTree1 = getHeight(root.getLeft());
        int heightSubTree2 = getHeight(root.getRight());
        return max(heightSubTree1, heightSubTree2) + 1;
    }
}