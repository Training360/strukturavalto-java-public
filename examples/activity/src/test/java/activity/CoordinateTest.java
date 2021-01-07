package activity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CoordinateTest {


    @Test
    public void testInvalidLatitude() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(190.5, -34.789);
        });
    }

    @Test
    public void testInvalidLongitude() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(30.5, -200);
        });
    }

    @Test
    public void testInvalidCoordinate() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-91.0, 180.1);
        });
    }

    @Test
    public void testCreateCoordinate() {
        Coordinate coordinate = new Coordinate(12.5, -34.789);
        assertEquals(12.5, coordinate.getLatitude());
        assertEquals(-34.789, coordinate.getLongitude());
    }
}