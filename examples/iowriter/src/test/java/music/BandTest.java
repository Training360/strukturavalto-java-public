package music;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BandTest {

    private Band band = new Band("Metallica", 1981);

    @Test
    public void createBandTest() {
        assertEquals("Metallica", band.getName());
        assertEquals(1981, band.getYear());
    }

}
