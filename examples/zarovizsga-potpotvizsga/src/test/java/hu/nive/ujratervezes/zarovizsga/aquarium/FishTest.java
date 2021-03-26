package hu.nive.ujratervezes.zarovizsga.aquarium;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class FishTest {

    @Test
    void test_fishIsAbstract() {
        assertTrue(Modifier.isAbstract(Fish.class.getModifiers()));
    }

    @Test
    void test_clownfish() {
        Clownfish clownfish = new Clownfish("Nemo", 5, "orange-white");
        assertEquals("Nemo", clownfish.getName());
        assertEquals(5, clownfish.getWeight());
        assertEquals("orange-white", clownfish.getColor());
        assertFalse(clownfish.hasMemoryLoss());
    }

    @Test
    void test_kong() {
        Kong kong = new Kong("Kong", 10, "black");
        assertEquals("Kong", kong.getName());
        assertEquals(10, kong.getWeight());
        assertEquals("black", kong.getColor());
        assertFalse(kong.hasMemoryLoss());
    }

    @Test
    void test_tangWithMemoryLoss() {
        Tang tang = new Tang("Dory", 6, "blue");
        assertEquals("Dory", tang.getName());
        assertEquals(6, tang.getWeight());
        assertEquals("blue", tang.getColor());
        assertTrue(tang.hasMemoryLoss());
    }

}