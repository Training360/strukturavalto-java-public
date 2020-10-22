package genericsusage;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestGenericUsage {

    @Test
    public void testGenericsUsage() {
        List<String> l = new ArrayList();
        l.add("John Doe");
        l.add("Jane Doe");

        String s = l.get(0);
        assertThat(s, equalTo("John Doe"));
    }
}
