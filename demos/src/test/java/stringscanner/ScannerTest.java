package stringscanner;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ScannerTest {

    @Test
    public void testScanner() {
        Scanner s = new Scanner("aaa,bbb,ccc,ddd").useDelimiter(",");
        List<String> l = new ArrayList<>();
        while (s.hasNext()) {
            l.add(s.next());
        }
        assertThat(l, equalTo(Arrays.asList("aaa", "bbb", "ccc", "ddd")));

        Scanner t = new Scanner("12 13 14");
        List<Integer> m = new ArrayList<>();
        while (t.hasNextInt()) {
            int i = t.nextInt();
            m.add(i);
        }
        assertThat(m, equalTo(Arrays.asList(12, 13, 14)));
    }
}
