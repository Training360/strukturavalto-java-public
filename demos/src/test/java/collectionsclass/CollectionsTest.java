package collectionsclass;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CollectionsTest {

    @Test
    public void testCollections() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        List<Integer> l = Collections.unmodifiableList(elements);
        assertThat(l, equalTo(Arrays.asList(1, 2)));

        elements.add(3);
        assertThat(l, equalTo(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testReverse() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        Collections.reverse(l);
        assertThat(l, equalTo(Arrays.asList(4, 3, 2, 1)));
    }

    @Test
    public void testShuffle() {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        Random random = new Random(5);
        Collections.shuffle(l, random);
        assertThat(l, equalTo(Arrays.asList(4, 1, 2, 3)));
    }
}
