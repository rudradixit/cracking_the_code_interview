package chapter4;

import chapter3.aux.Queue;
import chapter3.aux.TwoStackQueue;
import chapter4.aux.GraphNode;

import java.util.HashSet;
import java.util.Set;

public class Problem42 {
    public static <T> boolean hasConnection(GraphNode<T> source, GraphNode<T> destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Invalid source/destination nodes!");
        }

        Set<GraphNode<T>> tracking = new HashSet<>();
        Queue<GraphNode<T>> queue = new TwoStackQueue<>();
        queue.enqueue(source);

        GraphNode<T> queueNode;

        while (queue.size() > 0) {
            queueNode = queue.dequeue().get();

            if (queueNode == destination) {
                return true;
            }

            for (GraphNode<T> gn : queueNode.getConnections()) {
                if (!tracking.contains(gn)) {
                    queue.enqueue(gn);
                    tracking.add(gn);
                }
            }
        }

        return false;
    }
}