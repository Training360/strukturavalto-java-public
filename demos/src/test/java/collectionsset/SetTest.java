package collectionsset;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SetTest {

    @Test
    public void testSet() {
        Set<Trainer> s = new HashSet<>();

        s.add(new Trainer("Jack"));
        s.add(new Trainer("Jack"));

        assertThat(s.size(), equalTo(1));
        assertThat(s, equalTo(Set.of(new Trainer("Jack"))));
    }

    @Test
    public void testSetOrder() {
        Set<Trainer> s = new LinkedHashSet<>();

        s.add(new Trainer("Jane"));
        s.add(new Trainer("Jack"));

        assertThat(new ArrayList<>(s), equalTo(Arrays.asList(new Trainer("Jane"), new Trainer("Jack"))));
    }
}
