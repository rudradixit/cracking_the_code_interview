package chapter3.aux;

import java.util.Optional;

public interface Stack<T> {
    void push(T value);
    Optional<T> pop();
    Optional<T> peek();
    int size();
}