package chapter3.aux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SetOfStacks<T> implements Stack<T> {
    private int threshold;
    private List<Stack<T>> stacks = new ArrayList<>();

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Invalid value!");
        }
        
        
        if (stacks.isEmpty()) {            
            stacks.add(new SingleStack<>());
        }
        
        Stack<T> current = stacks.get(stacks.size() - 1);
        
        if (current.size() == threshold) {
            current = new SingleStack<>();
            stacks.add(current);
        }
        
        current.push(value);        
    }

    @Override
    public Optional<T> pop() {
        if (stacks.isEmpty()) {
            return Optional.empty();
        }
        
        Stack<T> current = stacks.get(stacks.size() - 1);
        return current.pop();
    }

    @Override
    public Optional<T> peek() {
        if (stacks.isEmpty()) {
            return Optional.empty();
        }
        
        Stack<T> current = stacks.get(stacks.size() - 1);
        return current.peek();
    }

    @Override
    public int size() {
        int sum = 0;

        for (Stack<T> s : stacks) {
            sum += s.size();
        }

        return sum;
    }

    public int numberOfStacks() {
        return stacks.size();
    }

    public Stack<T> get(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IllegalArgumentException("Invalid index!");
        }

        return stacks.get(index);
    }
}