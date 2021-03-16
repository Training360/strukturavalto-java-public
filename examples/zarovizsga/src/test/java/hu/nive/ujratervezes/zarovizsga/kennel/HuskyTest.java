package hu.nive.ujratervezes.zarovizsga.kennel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HuskyTest {

    @Test
    void testCreate() {
        Husky husky = new Husky("Morzsi");
        assertEquals("Morzsi", husky.getName());
        assertEquals(0, husky.getHappiness());
    }

    @Test
    void testFeed() {
        Husky husky = new Husky("Morzsi");
        husky.feed();
        assertEquals(4, husky.getHappiness());
    }

    @Test
    void testPlay() {
        Husky husky = new Husky("Morzsi");
        husky.play(4);
        assertEquals(12, husky.getHappiness());
    }
}
