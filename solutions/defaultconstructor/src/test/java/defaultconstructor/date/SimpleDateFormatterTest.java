package defaultconstructor.date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SimpleDateFormatterTest {

    private SimpleDate simpleDate;

    @Before
    public void setUp() {
        simpleDate = new SimpleDate();
        simpleDate.setDate(2016, 2, 29);
    }

    @After
    public void tearDown() {
        simpleDate = null;
    }

    @Test
    public void testFormatDateStringByCountryCodeHU() {

        assertThat(new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.HU, simpleDate), equalTo("2016-2-29"));
    }

    @Test
    public void testFormatDateStringByCountryCodeEN() {

        assertThat(new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.EN, simpleDate), equalTo("29-2-2016"));
    }

    @Test
    public void testFormatDateStringByCountryCodeUS() {

        assertThat(new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.US, simpleDate), equalTo("2-29-2016"));
    }

    @Test
    public void testFormatDateString() {

        assertThat(new SimpleDateFormatter().formatDateString(simpleDate), equalTo("2016-2-29"));
    }
}
