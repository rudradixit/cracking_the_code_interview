package chapter4;

import chapter4.aux.BinaryNode;
import chapter4.aux.SumStack;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. The path does not need to start or end
 * at the root or a leaf, but it must go in a straight line down.
 */
public class Problem49 {
    public static String findSumPaths(BinaryNode<Integer> node, int sum) {
        StringBuilder builder = new StringBuilder();
        _findSumPaths(node, sum, new SumStack(), builder);
        return builder.toString();
    }
    
    private static void _findSumPaths(BinaryNode<Integer> node, int sum, SumStack stack, StringBuilder output) {
        if (node == null) {
            return;
        }

        stack.push(node.getValue());
        
        if (stack.getSum() > sum) {
            stack.pop();
        } else if (stack.getSum() < sum) {
            _findSumPaths(node.getLeft(), sum, stack, output);
            _findSumPaths(node.getRight(), sum, stack, output);
        } else {        
            output.append((output.length() == 0) ? "" : ",").append(stack.toString());
            stack.pop();
            _findSumPaths(node.getLeft(), sum, stack, output);
            _findSumPaths(node.getRight(), sum, stack, output);
        }
    }
}