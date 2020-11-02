package isahasa.fleet;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinerTest {

    @Test
    public void load() {
        Liner liner = new Liner(100);

        assertEquals(0, liner.loadPassenger(56));
        assertEquals(56, liner.getPassengers());
    }

    @Test
    public void loadToMuch() {
        Liner liner = new Liner(100);

        assertEquals(11, liner.loadPassenger(111));
        assertEquals(100, liner.getPassengers());
    }
}