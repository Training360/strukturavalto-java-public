package interfaces.animal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ZooTest {

    @Test
    public void getNumberOfLegsWithEmptyList() {
        List<Animal> animals = new ArrayList<>();
        Zoo zoo = new Zoo(animals);

        assertEquals(0, zoo.getNumberOfLegs());
    }

    @Test
    public void getNumberOfLegsWithAList() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Duck());
        animals.add(new Worm());
        animals.add(new Duck());
        animals.add(new Lion());
        Zoo zoo = new Zoo(animals);

        assertEquals(8, zoo.getNumberOfLegs());
    }

    @Test
    public void getNumberOfAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Duck());
        animals.add(new Worm());
        animals.add(new Duck());
        animals.add(new Lion());
        Zoo zoo = new Zoo(animals);

        assertEquals(4, zoo.getNumberOfAnimals());
    }
}