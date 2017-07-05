package chapter4;

import chapter4.aux.BinaryNode;

/**
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Problem45 {
    public static <T extends Comparable> boolean isBinarySearchTree(BinaryNode<T> root) {
        if (root == null) {
            return true;
        }
        
        if (root.getLeft() != null && root.getLeft().getValue().compareTo(root.getValue()) >= 0) {
            return false;
        }
        
        if (root.getRight() != null && root.getRight().getValue().compareTo(root.getValue()) < 0) {
            return false;
        }

        boolean leftResult = isBinarySearchTree(root.getLeft());
        
        if (!leftResult) {
            return false;
        }
        
        return isBinarySearchTree(root.getRight());
    }
}