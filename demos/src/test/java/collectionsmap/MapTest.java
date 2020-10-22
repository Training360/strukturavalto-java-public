package collectionsmap;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MapTest {

    @Test
    public void testMap() {
        Map<String, String> codes = new HashMap<>();
        assertThat(codes.isEmpty(), equalTo(true));

        codes.put("200", "OK");
        codes.put("404", "Not found");

        Map<String, String> expected = new HashMap<>();
        expected.put("200", "OK");
        expected.put("404", "Not found");

        assertThat(codes, equalTo(expected));

        codes.put("404", "Not Found");
        String s = codes.get("404");

        assertThat(s, equalTo("Not Found"));

        codes.put("304", "Not Modified");

        codes.remove("304");
        assertThat(codes.containsKey("304"), equalTo(false));
        assertThat(codes.containsValue("OK"), equalTo(true));

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
        assertThat(t.getName(), equalTo("Jane"));
    }
}
