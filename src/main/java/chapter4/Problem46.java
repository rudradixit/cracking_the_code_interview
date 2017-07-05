package chapter4;

import chapter4.aux.BinaryNodeParentLink;

/**
 * Write an algorithm to find the 'next' node (i.e. in-order successor) of a given node
 * in a binary search tree. You may assume that each node has a link to its parent.
 */
public class Problem46 {
    public static <T extends Comparable> BinaryNodeParentLink<T> getNext(BinaryNodeParentLink<T> node) {        
        return _getNext(node, node, false);
    } 
    
    private static <T extends Comparable> BinaryNodeParentLink<T> _getNext(BinaryNodeParentLink<T> root, BinaryNodeParentLink<T> node, boolean isRight) {
        if (root == null) {
            return null;
        }

        BinaryNodeParentLink<T> parent = root.getParent();
        
        if (isRight) {
            if (parent == null) {
                System.out.println("No 'next' node is available.");
                return null;
            } else {
                if (parent.getValue().compareTo(node.getValue()) >= 0) {
                    return parent;
                } else {
                    return _getNext(parent, node, true);
                }
            }
        }
        
        if (parent != null && parent.getValue().compareTo(node.getValue()) >= 0) {
            return parent;
        } else if (root.getRight() != null && root.getValue().compareTo(root.getRight().getValue()) < 0) {
            return (BinaryNodeParentLink<T>)node.getRight();
        } else {
            return _getNext(root.getParent(), node, true);
        }
    }
}