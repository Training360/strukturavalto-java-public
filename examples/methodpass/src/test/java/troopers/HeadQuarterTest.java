package troopers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadQuarterTest {

    @Test
    public void testAddTrooper() {
        HeadQuarter headQuarter = new HeadQuarter();
        Trooper trooper = new Trooper("Jake Doe");

        headQuarter.addTrooper(trooper);

        assertEquals(1, headQuarter.getTroopers().size());
        assertEquals("Jake Doe", headQuarter.getTroopers().get(0).getName());
    }

    @Test
    public void testMoveTrooperByName() {
        HeadQuarter headQuarter = new HeadQuarter();
        Trooper johnTrooper = new Trooper("John Doe");
        Trooper jakeTrooper = new Trooper("Jake Doe");

        headQuarter.addTrooper(johnTrooper);
        headQuarter.addTrooper(jakeTrooper);

        headQuarter.moveTrooperByName("Jake Doe", new Position(4, 7));

        assertEquals(4, jakeTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(7, jakeTrooper.getPosition().getPosY(), 0.000001);

        assertEquals(0, johnTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(0, johnTrooper.getPosition().getPosY(), 0.000001);
    }

    @Test
    public void testMoveClosestTrooper() {
        HeadQuarter headQuarter = new HeadQuarter();
        Trooper johnTrooper = new Trooper("John Doe");
        Trooper jakeTrooper = new Trooper("Jake Doe");
        johnTrooper.changePosition(new Position(8, 2));
        jakeTrooper.changePosition(new Position(-2, 5));
        headQuarter.addTrooper(johnTrooper);
        headQuarter.addTrooper(jakeTrooper);

        Position target = new Position(10, -4);

        headQuarter.moveClosestTrooper(target);

        assertEquals(10, johnTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(-4, johnTrooper.getPosition().getPosY(), 0.000001);

        assertEquals(-2, jakeTrooper.getPosition().getPosX(), 0.000001);
        assertEquals(5, jakeTrooper.getPosition().getPosY(), 0.000001);

    }
}
