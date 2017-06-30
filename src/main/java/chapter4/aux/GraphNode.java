package chapter4.aux;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    private T value;
    private List<GraphNode<T>> connections = new ArrayList<>();

    public GraphNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public List<GraphNode<T>> getConnections() {
        return connections;
    }

    public GraphNode<T> setConnections(List<GraphNode<T>> connections) {
        if (connections != null) {
            this.connections.addAll(connections);
        }
        return this;
    }

    @Override
    public String toString() {
        return (value == null) ? "N/A" : value.toString();
    }
}