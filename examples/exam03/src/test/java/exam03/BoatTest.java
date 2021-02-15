package exam03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoatTest {

    @Test
    void create() {
        Boat boat = new Boat("WetDreams", 15);
        assertEquals("WetDreams", boat.getName());
        assertEquals(15, boat.getMaxPassengers());
    }
}
