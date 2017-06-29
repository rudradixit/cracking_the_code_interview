package chapter3;

import chapter3.aux.SingleStack;
import chapter3.aux.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem36 {
    private Stack<Integer> stack;

    @Before
    public void setup() {
        stack = new SingleStack<>();
    }

    @Test
    public void testWithEmpty() {
        Stack<Integer> sortedStack = Problem36.sort(stack);
        assertEquals(stack, sortedStack);
    }

    @Test
    public void testWithOneElement() {
        stack.push(99);
        Stack<Integer> sortedStack = Problem36.sort(stack);
        assertEquals(stack, sortedStack);
    }

    @Test
    public void testWithTwoElements() {
        stack.push(99);
        stack.push(10);
        Stack<Integer> output = new SingleStack<>();
        output.push(10);
        output.push(99);
        Stack<Integer> sortedStack = Problem36.sort(stack);
        assertEquals(output, sortedStack);
    }

    @Test
    public void testWithThreeElements() {
        stack.push(34);
        stack.push(99);
        stack.push(10);
        Stack<Integer> output = new SingleStack<>();
        output.push(10);
        output.push(34);
        output.push(99);
        Stack<Integer> sortedStack = Problem36.sort(stack);
        assertEquals(output, sortedStack);
    }
}