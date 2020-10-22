package interfacedefaultmethods.print;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PrintableTest {

    @Test
    public void testGetColorWithDefaultImplementation() {
        Printable printable = new TestPrintable();
        assertThat(printable.getColor(0), equalTo(Printable.BLACK));
    }

}
