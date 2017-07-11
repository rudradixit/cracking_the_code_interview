package chapter9;

import chapter4.aux.TernaryNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps
 * at a time. Implement a method to count how many possible ways the child can run up the stairs.
 */
public class Problem91 {
    public static int run(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid number of steps!");
        }
               
        List<TernaryNode<Integer>> trees = new ArrayList<>();
        trees.add(buildTree(new TernaryNode<>(1), n, 1));
        
        if (n > 1) {
            trees.add(buildTree(new TernaryNode<>(2), n, 2));
        }
        
        if (n > 2) {
            trees.add(buildTree(new TernaryNode<>(3), n, 3));
        }
        
        return countLeafNodes(trees);
    }
    
    private static TernaryNode<Integer> buildTree(TernaryNode<Integer> node, int n, int sum) {
        if (sum < n) {
            for (int i=3; i>=1; i--) {
                if (i <= (n - sum)) {
                    node.setChild(i, new TernaryNode<>(i));
                    buildTree(node.getChild(i), n, sum + i);
                }
            }
        }
        
        return node;
    }

    private static int countLeafNodes(List<TernaryNode<Integer>> trees) {
        int sum = 0;
        
        for (TernaryNode<Integer> tree : trees) {
            sum += countLeafNodes(tree);
        }
        
        return sum;
    }
    
    private static int countLeafNodes(TernaryNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        
        if (node.isLeaf()) {
            return 1;
        }
        
        return countLeafNodes(node.getLeft()) +
            countLeafNodes(node.getMiddle()) +
            countLeafNodes(node.getRight());
    }
}