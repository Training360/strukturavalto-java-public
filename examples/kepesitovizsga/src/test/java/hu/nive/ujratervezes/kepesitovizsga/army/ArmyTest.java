package hu.nive.ujratervezes.kepesitovizsga.army;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {

    Army army;

    @BeforeEach
    void init() {
        army = new Army();
    }

    @Test
    void testGetArmySizeEmpty() {
        assertEquals(0, army.getArmySize());
    }

    @Test
    void testAddUnit() {
        army.addUnit(new HeavyCavalry());
        assertEquals(1, army.getArmySize());
    }

    @Test
    void testGetArmyDamageEmptyArmy() {
        assertEquals(0, army.getArmyDamage());
    }

    @Test
    void testGetArmyDamage_oneOfEachKind() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Archer());
        assertEquals(90, army.getArmyDamage());
    }

    @Test
    void testDamageAll_someRemain() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Swordsman(false));
        army.addUnit(new Archer());
        army.damageAll(80);
        army.damageAll(80);
        assertEquals(2, army.getArmySize());
    }

    @Test
    void testDamageAll_noneRemain() {
        army.addUnit(new HeavyCavalry());
        army.addUnit(new Swordsman(true));
        army.addUnit(new Swordsman(false));
        army.addUnit(new Archer());
        army.damageAll(200);
        army.damageAll(200);
        assertEquals(0, army.getArmySize());
    }

}
