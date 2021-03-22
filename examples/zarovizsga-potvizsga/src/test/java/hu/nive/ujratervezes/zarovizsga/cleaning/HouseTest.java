package hu.nive.ujratervezes.zarovizsga.cleaning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void create() {
        House house = new House("Budapest, Fo ut. 1.", 100);
        assertEquals("Budapest, Fo ut. 1.", house.getAddress());
    }

    @Test
    void clean() {
        House house = new House("Budapest, Fo ut. 1.", 100);
        assertEquals(8_000, house.clean());
    }
}