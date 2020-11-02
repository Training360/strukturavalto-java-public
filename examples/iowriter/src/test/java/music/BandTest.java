package music;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BandTest {

    private Band band = new Band("Metallica", 1981);

    @Test
    public void createBandTest() {
        assertEquals("Metallica", band.getName());
        assertEquals(1981, band.getYear());
    }

}
