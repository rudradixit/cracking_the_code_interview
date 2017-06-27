package chapter3;

import chapter3.aux.SetOfStacks;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem33 {
    @Test
    public void testWithUnderCapacity() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        assertEquals(1, setOfStacks.numberOfStacks());
        assertEquals(3, setOfStacks.get(0).size());
    }

    @Test
    public void testWithOverCapacity() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(3);
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        assertEquals(2, setOfStacks.numberOfStacks());
        assertEquals(3, setOfStacks.get(0).size());
        assertEquals(1, setOfStacks.get(1).size());
    }
}