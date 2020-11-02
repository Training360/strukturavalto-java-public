package collectionsmap;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    public void testMap() {
        Map<String, String> codes = new HashMap<>();
        assertTrue(codes.isEmpty());

        codes.put("200", "OK");
        codes.put("404", "Not found");

        Map<String, String> expected = new HashMap<>();
        expected.put("200", "OK");
        expected.put("404", "Not found");

        assertEquals(expected, codes);

        codes.put("404", "Not Found");
        String s = codes.get("404");

        assertEquals("Not Found", s);

        codes.put("304", "Not Modified");

        codes.remove("304");
        assertFalse(codes.containsKey("304"));
        assertTrue(codes.containsValue("OK"));

        for (Map.Entry entries: codes.entrySet()) {
            System.out.println(entries.getKey());
            System.out.println(entries.getValue());
        }
    }

    @Test
    public void testTrainersMap() {
        List<Trainer> trainers = Arrays.asList(
                new Trainer(1L, "John"),
                new Trainer(2L, "Jack"),
                new Trainer(3L, "Jane"),
                new Trainer(4L, "Joe")
        );

        Map<Long, Trainer> m = new HashMap<>();
        for (Trainer t: trainers) {
            m.put(t.getId(), t);
        }

        Trainer t = m.get(3L);
        assertEquals("Jane", t.getName());
    }
}
