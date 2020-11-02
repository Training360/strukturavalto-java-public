package interfaceextends.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AstroBoyTest {

    @Test
    public void testMoveTo() {
        //Given
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);
        //When
        astroBoy.moveTo(targetPoint);
        //Then
        assertEquals(targetPoint, astroBoy.getPosition());
        assertEquals(1, astroBoy.getPath().size());
        assertEquals(targetPoint.getX(), astroBoy.getPath().get(0).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(0).getY());
        assertEquals(targetPoint.getZ(), astroBoy.getPath().get(0).getZ());
    }

    @Test
    public void testFastMoveTo() {
        //Given
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        Point targetPoint = new Point(12L, 23L, 0);
        //When
        astroBoy.fastMoveTo(targetPoint);
        //Then
        assertEquals(targetPoint.getX(), astroBoy.getPosition().getX());
        assertEquals(targetPoint.getY(), astroBoy.getPosition().getY());
        assertEquals(targetPoint.getZ(), astroBoy.getPosition().getZ());

        assertEquals(3, astroBoy.getPath().size());
        assertEquals(initialPoint.getX(), astroBoy.getPath().get(0).getX());
        assertEquals(initialPoint.getY(), astroBoy.getPath().get(0).getY());
        assertEquals(AstroBoy.ALTITUDE, astroBoy.getPath().get(0).getZ());

        assertEquals(targetPoint.getX(), astroBoy.getPath().get(1).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(1).getY());
        assertEquals(AstroBoy.ALTITUDE, astroBoy.getPath().get(1).getZ());

        assertEquals(targetPoint.getX(), astroBoy.getPath().get(2).getX());
        assertEquals(targetPoint.getY(), astroBoy.getPath().get(2).getY());
        assertEquals(0L, astroBoy.getPath().get(2).getZ());
    }

    @Test
    public void testRotate() {
        //Given
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        final int angle = 12;
        //When
        astroBoy.rotate(angle);
        //Then
        assertEquals(angle, astroBoy.getAngle());
    }

    @Test
    public void testLiftTo() {
        //Given
        Point initialPoint = new Point(0, 0, 0);
        AstroBoy astroBoy = new AstroBoy(initialPoint);
        final long altitude = 12;
        //When
        astroBoy.liftTo(altitude);
        //Then
        assertEquals(altitude, astroBoy.getAltitude());
    }
}