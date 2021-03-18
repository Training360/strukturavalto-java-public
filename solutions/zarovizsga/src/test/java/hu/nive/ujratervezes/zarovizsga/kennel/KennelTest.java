package hu.nive.ujratervezes.zarovizsga.kennel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KennelTest {

    Kennel kennel = new Kennel();

    @BeforeEach
    void init() {
        Beagle beagle = new Beagle("Bigli");
        kennel.addDog(beagle);
        Husky husky = new Husky("Morzsi");
        kennel.addDog(husky);
        Husky husky2 = new Husky("Zokni");
        kennel.addDog(husky2);
    }

    @Test
    void testAddDog() {
        List<Dog> dogs = kennel.getDogs();
        assertEquals(3, dogs.size());
        assertEquals("Morzsi", dogs.get(1).getName());
    }

    @Test
    void testFeedAll() {
        kennel.feedAll();
        assertEquals(2, kennel.getDogs().get(0).getHappiness());
        assertEquals(4, kennel.getDogs().get(1).getHappiness());
    }

    @Test
    void testFindByName() {
        Dog dog = kennel.findByName("Morzsi");
        assertTrue(dog instanceof Husky);
        assertEquals("Morzsi", dog.getName());
    }

    @Test
    void testNotFound() {
        assertThrows(IllegalArgumentException.class,
                () -> kennel.findByName("Korom"));
    }

    @Test
    void testPlayWith() {
        kennel.playWith("Morzsi", 4);
        assertEquals(12, kennel.findByName("Morzsi").getHappiness());
    }

    @Test
    void testHappyDogNames() {
        kennel.playWith("Morzsi", 4);
        kennel.playWith("Bigli", 4);
        kennel.playWith("Zokni", 2);

        assertEquals(List.of("Bigli", "Morzsi"), kennel.getHappyDogNames(7));
    }
}
