package hu.nive.ujratervezes.kepesitovizsga_pot_potvizsga.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LionTest {

    @Test
    public void testCreate() {
        ZooAnimal lion = new Lion("Simba");

        Assertions.assertEquals("Simba", lion.getName());
        Assertions.assertEquals(0, lion.getLength());
        Assertions.assertEquals(0L, lion.getWeight());
        Assertions.assertEquals(AnimalType.LION, lion.getType());
    }
}