package chapter3.aux;

import java.util.Optional;

public interface Queue<T> {
    void enqueue(T value);
    Optional<T> dequeue();
    int size();
}