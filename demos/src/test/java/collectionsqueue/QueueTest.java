package collectionsqueue;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        int i = q.element();
        assertThat(i, equalTo(1));

        i = q.element();
        assertThat(i, equalTo(1));

        i = q.remove();
        assertThat(i, equalTo(1));

        i = q.remove();
        assertThat(i, equalTo(2));

        assertThat(q.isEmpty(), equalTo(true));
    }

    @Test
    public void testStack() {
        Deque<Integer> d = new LinkedList<>();
        d.push(1);
        d.push(2);
        d.push(3);

        int i = d.peek();
        assertThat(i, equalTo(3));
        i = d.peek();
        assertThat(i, equalTo(3));

        i = d.pop();
        assertThat(i, equalTo(3));

        i = d.pop();
        assertThat(i, equalTo(2));

        d.pop();
        assertThat(d.isEmpty(), equalTo(true));
    }
}
