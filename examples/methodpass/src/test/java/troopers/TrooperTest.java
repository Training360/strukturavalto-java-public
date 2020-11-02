package troopers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrooperTest {


    @Test
    public void testCreate() {
        Trooper trooper = new Trooper("Jake Doe");

        assertEquals("Jake Doe", trooper.getName());
        assertEquals(0, trooper.getPosition().getPosX(), 0);
        assertEquals(0, trooper.getPosition().getPosY(), 0);
    }

    @Test
    public void testCreateWithEmptyName() {

        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Trooper(""));
        assertEquals("Name must not be empty.", ex.getMessage());

    }

    @Test
    public void testChangePosition() {
        Trooper trooper = new Trooper("John Doe");
        Position target = new Position(3, 4);
        trooper.changePosition(target);

        assertEquals(3, trooper.getPosition().getPosX(), 0.000001);
        assertEquals(4, trooper.getPosition().getPosY(), 0.000001);
    }

    @Test
    public void testChangePositionToNowhere() {
        Trooper trooper = new Trooper("John Doe");
        Exception ex = assertThrows(IllegalArgumentException.class, () -> trooper.changePosition(null));

    }

    @Test
    public void testDistanceFrom() {
        Trooper trooper = new Trooper("John Doe");
        Position target = new Position(3, 4);

        assertEquals(5, trooper.distanceFrom(target), 0.000001);
    }
}
