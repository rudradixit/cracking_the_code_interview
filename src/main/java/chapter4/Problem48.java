package chapter4;

import chapter4.aux.BinaryNode;

/**
 * You have two very large binary trees: T1. with millions of nodes, and T2, with hundreds
 * of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n
 * is identical to T2. That is, if you cut off the tree at node n, the two trees would be
 * identical.
 */
public class Problem48 {
    public static <T> boolean contains(BinaryNode<T> t1, BinaryNode<T> t2) {
        if (t1 == null || t2 == null) {
            throw new IllegalArgumentException("Invalid tree(s)!");
        }
        
        BinaryNode<T> t1StartNode = find(t1, t2);
        return t1StartNode != null && matches(t1StartNode, t2);
    }
    
    private static <T> BinaryNode<T> find(BinaryNode<T> node, BinaryNode<T> t2) {
        if (node == null) {
            return null;
        }

        if (node.equals(t2)) {
            return node;
        }

        BinaryNode<T> found = find(node.getLeft(), t2);
        return (found == null) ? find(node.getRight(), t2) : found;
    }
    
    private static <T> boolean matches(BinaryNode<T> t1, BinaryNode<T> t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        if (t2 == null) {
            return false;
        }

        if (!t1.equals(t2)) {
            return false;
        }

        return matches(t1.getLeft(), t2.getLeft()) && matches (t1.getRight(), t2.getRight());
    }
}