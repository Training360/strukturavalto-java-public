package genericsusage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestGenericUsage {

    @Test
    public void testGenericsUsage() {
        List<String> l = new ArrayList();
        l.add("John Doe");
        l.add("Jane Doe");

        String s = l.get(0);
        assertEquals("John Doe", s);
    }
}
