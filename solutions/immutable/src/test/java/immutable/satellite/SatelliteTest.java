package immutable.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SatelliteTest {


    @Test
    public void emptyParameterShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Satellite(new CelestialCoordinates(12, 23, 45), ""));
        assertEquals("Register ident must not be empty!", ex.getMessage());
    }

    @Test
    public void testModifyDestination() {
        // Given
        Satellite satellite = new Satellite(new CelestialCoordinates(12, 23, 45), "ASD567");
        // When
        satellite.modifyDestination(new CelestialCoordinates(2, 2, 2));
        //Then
        assertEquals("ASD567: CelestialCoordinates: x=14, y=25, z=47", satellite.toString());
    }
}
