package abstractclass.gamecharacter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    public void creation() {
        Point point = new Point(5, 6);

        assertEquals(5L, point.getX());
        assertEquals(6L, point.getY());
    }

    @Test
    public void distance() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(100, 100);


        assertEquals(141L, point1.distance(point2));
    }

}