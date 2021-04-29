package hu.nive.ujratervezes.kepesitovizsga.army;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MilitaryUnitTest {

    @Test
    void testArcher() {
        Archer archer = new Archer();
        assertEquals(20, archer.doDamage());
        archer.sufferDamage(20);
        assertEquals(30, archer.getHitPoints());
    }

    @Test
    void testHeavyCavalry() {
        HeavyCavalry heavyCavalry = new HeavyCavalry();
        assertEquals(60, heavyCavalry.doDamage());
        assertEquals(20, heavyCavalry.doDamage());
        heavyCavalry.sufferDamage(20);
        assertEquals(140, heavyCavalry.getHitPoints());
    }

    @Test
    void testSwordsmanArmored() {
        Swordsman swordsman = new Swordsman(true);
        swordsman.sufferDamage(20);
        assertEquals(100, swordsman.getHitPoints());
        swordsman.sufferDamage(20);
        assertEquals(90, swordsman.getHitPoints());
        assertEquals(10, swordsman.doDamage());
    }

    @Test
    void testSwordsmanUnarmored() {
        Swordsman swordsman = new Swordsman(false);
        swordsman.sufferDamage(20);
        assertEquals(100, swordsman.getHitPoints());
        swordsman.sufferDamage(20);
        assertEquals(80, swordsman.getHitPoints());
        assertEquals(10, swordsman.doDamage());
    }
}
