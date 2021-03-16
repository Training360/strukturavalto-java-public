package hu.nive.ujratervezes.zarovizsga.kennel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeagleTest {

    @Test
    void testCreate() {
        Beagle beagle = new Beagle("Bigli");
        assertEquals("Bigli", beagle.getName());
        assertEquals(0, beagle.getHappiness());
    }

    @Test
    void testFeed() {
        Beagle beagle = new Beagle("Bigli");
        beagle.feed();
        assertEquals(2, beagle.getHappiness());
    }

    @Test
    void testPlay() {
        Beagle beagle = new Beagle("Bigli");
        beagle.play(3);
        assertEquals(6, beagle.getHappiness());
    }

}