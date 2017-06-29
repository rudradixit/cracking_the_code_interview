package chapter3;

import chapter3.aux.SingleStack;
import chapter3.aux.Stack;

import java.util.Optional;

public class Problem36 {
    public static <T extends Comparable<T>> Stack<T> sort(Stack<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Invalid stack!");
        }
        
        if (stack.size() <= 1) {
            return stack;
        }
        
        Stack<T> auxiliary = new SingleStack<>();
        Optional<T> top;
        Optional<T> sortedTop;
        
        while (stack.size() > 0) {
            top = stack.pop();
            sortedTop = auxiliary.peek();
            
            if (!sortedTop.isPresent()) {
                auxiliary.push(top.get());
            } else {
                int count = 0;
                
                while (sortedTop.isPresent() && top.get().compareTo(sortedTop.get()) < 0) {
                    sortedTop = auxiliary.pop();
                    count++;
                    stack.push(sortedTop.get());
                    sortedTop = auxiliary.peek();
                }
                
                auxiliary.push(top.get());
                
                for (int i=0; i<count; i++) {
                    auxiliary.push(stack.pop().get());
                }
            }
        }
        
        return auxiliary;
    }
}