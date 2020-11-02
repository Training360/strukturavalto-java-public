package immutable.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CelestialCoordinatesTest {

    @Test
    public void testToString() {
        assertEquals("CelestialCoordinates: x=12, y=23, z=45",new CelestialCoordinates(12, 23, 45).toString());
    }
}
