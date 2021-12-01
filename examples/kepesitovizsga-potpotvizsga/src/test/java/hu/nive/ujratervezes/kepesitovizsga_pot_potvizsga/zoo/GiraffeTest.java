package hu.nive.ujratervezes.kepesitovizsga_pot_potvizsga.zoo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GiraffeTest {

    @Test
    public void testCreate() {
        ZooAnimal giraffe = new Giraffe("Momba", 3);

        Assertions.assertEquals("Momba", giraffe.getName());
        Assertions.assertEquals(3, giraffe.getLength());
        Assertions.assertEquals(0L, giraffe.getWeight());
        Assertions.assertEquals(AnimalType.GIRAFFE, giraffe.getType());
    }
}
