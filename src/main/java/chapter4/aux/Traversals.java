package chapter4.aux;

import chapter3.aux.Queue;
import chapter3.aux.TwoStackQueue;

import java.util.function.Function;

public class Traversals {
    public static <T> void preOrder(BinaryNode<T> node, Function<BinaryNode<T>, Void> function) {
        if (node == null) {
            return;
        }
        
        function.apply(node);
        
        preOrder(node.getLeft(), function);
        preOrder(node.getRight(), function);
    }

    public static <T> void inOrder(BinaryNode<T> node, Function<BinaryNode<T>, Void> function) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft(), function);
        function.apply(node);
        inOrder(node.getRight(), function);
    }

    public static <T> void postOrder(BinaryNode<T> node, Function<BinaryNode<T>, Void> function) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft(), function);
        postOrder(node.getRight(), function);
        function.apply(node);
    }
    
    public static <T> void breadthFirst(BinaryNode<T> node, Function<BinaryNode<T>, Void> function) {
        if (node == null) {
            return;
        }
        
        BinaryNode<T> queueNode;
        Queue<BinaryNode<T>> queue = new TwoStackQueue<>();
        queue.enqueue(node);
        
        while (queue.size() > 0) {
            queueNode = queue.dequeue().get();
            function.apply(queueNode);
            
            if (queueNode.getLeft() != null) {
                queue.enqueue(queueNode.getLeft());
            }
            
            if (queueNode.getRight() != null) {
                queue.enqueue(queueNode.getRight());
            }
        }
    }
}