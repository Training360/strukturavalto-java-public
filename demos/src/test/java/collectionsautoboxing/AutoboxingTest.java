package collectionsautoboxing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AutoboxingTest {

    @Test
    public void testAutoboxing() {
        List<Integer> l = new ArrayList<>();
        l.add(5);

        int i = l.get(0);
        assertThat(i, equalTo(5));

        l.add(8);

        l.add(null);
        assertThat(l.get(2), equalTo(null));
    }

    @Test
    public void testMap() {
        Map<Character, Integer> m = new HashMap<>();
        //
        m.put('a', 1);

        m.put('a', m.get('a') + 1);

        assertThat(m.get('a'), equalTo(2));
    }
}
