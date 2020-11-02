package collectionsqueue;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        int i = q.element();
        assertEquals(1, i);

        i = q.element();
        assertEquals(1, i);

        i = q.remove();
        assertEquals(1, i);

        i = q.remove();
        assertEquals(2, i);

        assertTrue(q.isEmpty());
    }

    @Test
    public void testStack() {
        Deque<Integer> d = new LinkedList<>();
        d.push(1);
        d.push(2);
        d.push(3);

        int i = d.peek();
        assertEquals(3, i);
        i = d.peek();
        assertEquals(3, i);

        i = d.pop();
        assertEquals(3, i);

        i = d.pop();
        assertEquals(2, i);

        d.pop();
        assertTrue(d.isEmpty());
    }
}
