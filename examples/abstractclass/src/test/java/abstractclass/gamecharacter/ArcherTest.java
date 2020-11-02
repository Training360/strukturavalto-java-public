package abstractclass.gamecharacter;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ArcherTest {

    @Test
    public void creation() {
        Random random = new Random(123);
        Character character = new Archer(new Point(5, 10), random);

        assertEquals(100, character.getHitPoint());
        assertTrue(character.isAlive());
        assertEquals(5L, character.getPosition().getX());
        assertEquals(10L, character.getPosition().getY());
    }

    @Test
    public void kill() {
        Random random = new Random(123);
        Archer offender = new Archer(new Point(0, 0), random);
        Character defender = new Archer(new Point(12, 0), random);

        while (defender.getHitPoint() > 0) {
            offender.secondaryAttack(defender);
        }

        assertTrue(defender.getHitPoint() <= 0);
        assertFalse(defender.isAlive());
    }

    @Test
    public void secondaryAttack() throws Exception {
        Random random = new Random(123);
        Archer offender = new Archer(new Point(0, 0), random);
        Character defender = new Archer(new Point(12, 0), random);

        offender.secondaryAttack(defender);

        assertEquals(100, offender.getHitPoint());
        assertTrue(defender.getHitPoint() >= 96);
        assertEquals(99, offender.getNumberOfArrow());
    }

}