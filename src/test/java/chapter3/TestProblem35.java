package chapter3;

import chapter3.aux.Queue;
import chapter3.aux.TwoStackQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestProblem35 {
    private Queue<String> queue;

    @Before
    public void setup() {
        queue = new TwoStackQueue<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnqueueWithNull() {
        queue.enqueue(null);
    }

    @Test
    public void testDequeueWithEmpty() {
        assertEquals(0, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testValidOperations() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }
}