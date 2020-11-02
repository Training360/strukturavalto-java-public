package collectionsautoboxing;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AutoboxingTest {

    @Test
    public void testAutoboxing() {
        List<Integer> l = new ArrayList<>();
        l.add(5);

        int i = l.get(0);
        assertEquals(5, i);

        l.add(8);

        l.add(null);
        assertNull(l.get(2));
    }

    @Test
    public void testMap() {
        Map<Character, Integer> m = new HashMap<>();
        //
        m.put('a', 1);

        m.put('a', m.get('a') + 1);

        assertEquals(2, m.get('a'));
    }
}
