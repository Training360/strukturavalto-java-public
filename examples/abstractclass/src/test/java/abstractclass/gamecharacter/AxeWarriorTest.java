package abstractclass.gamecharacter;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AxeWarriorTest {

    @Test
    public void creation() {
        Random random = new Random(123);
        Character character = new AxeWarrior(new Point(5, 10), random);

        assertEquals(100, character.getHitPoint());
        assertTrue(character.isAlive());
        assertEquals(5L, character.getPosition().getX());
        assertEquals(10L, character.getPosition().getY());
    }

    @Test
    public void secondaryAttack() {
        Random random = new Random(123);
        Character offender = new AxeWarrior(new Point(0, 0), random);
        Character defender = new AxeWarrior(new Point(0, 0), random);
        offender.secondaryAttack(defender);

        assertEquals(100, offender.getHitPoint());
        assertTrue(defender.getHitPoint() >= 80);
    }
}