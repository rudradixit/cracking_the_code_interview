package chapter3.aux;

import java.util.Optional;

public class TwoStackQueue<T> implements Queue<T> {
    private Stack<T> stack1 = new SingleStack<>();
    private Stack<T> stack2 = new SingleStack<>();

    @Override
    public void enqueue(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Invalid value!");
        }

        stack1.push(value);
    }

    @Override
    public Optional<T> dequeue() {
        if (size() == 0) {
            return Optional.empty();
        }

        Optional<T> element = stack1.pop();

        while (element.isPresent()) {
            stack2.push(element.get());
            element = stack1.pop();
        }

        Optional<T> first = stack2.pop();
        element = stack2.pop();

        while (element.isPresent()) {
            stack1.push(element.get());
            element = stack2.pop();
        }

        return first;
    }

    @Override
    public int size() {
        return stack1.size();
    }
}