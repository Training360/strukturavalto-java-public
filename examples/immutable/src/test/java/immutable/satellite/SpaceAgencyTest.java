package immutable.satellite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpaceAgencyTest {


    @Test
    public void nullParameterShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new SpaceAgency().registerSatellite(null));
        assertEquals("Parameter must not be null!", ex.getMessage());
    }

    @Test
    public void testRegisterSatellite() {
        // Given
        SpaceAgency sa = new SpaceAgency();
        // When
        sa.registerSatellite((new Satellite(new CelestialCoordinates(12, 23, 45), "ASD345")));
        sa.registerSatellite((new Satellite(new CelestialCoordinates(22, 33, 44), "QWE789")));
        //Then
        assertEquals("[ASD345: CelestialCoordinates: x=12, y=23, z=45, QWE789: CelestialCoordinates: x=22, y=33, z=44]", sa.toString());
    }

    @Test
    public void testNotFoundSatelliteByRegisterIdent() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new SpaceAgency().findSatelliteByRegisterIdent("XXX123"));
        assertEquals("Satellite with the given registration cannot be found!XXX123", ex.getMessage());
    }

    @Test
    public void testFindSatelliteByRegisterIdent() {
        // Given
        SpaceAgency sa = new SpaceAgency();
        // When
        sa.registerSatellite((new Satellite(new CelestialCoordinates(12, 23, 45), "ASD345")));
        sa.registerSatellite((new Satellite(new CelestialCoordinates(22, 33, 44), "QWE789")));
        //Then
        assertEquals("QWE789: CelestialCoordinates: x=22, y=33, z=44", sa.findSatelliteByRegisterIdent("QWE789").toString());
    }
}
