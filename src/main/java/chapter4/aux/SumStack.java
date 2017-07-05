package chapter4.aux;

import chapter3.aux.SingleStack;

import java.util.Optional;

public class SumStack extends SingleStack<Integer> {
    private int sum;
    
    @Override
    public void push(Integer value) {
        super.push(value);
        sum += value;
    }
    
    @Override
    public Optional<Integer> pop() {
        Optional<Integer> optional = super.pop();
      
        if (optional.isPresent()) {
            sum -= optional.get();
        }

        return optional;
    }
    
    public int getSum() {
        return sum;
    }
}