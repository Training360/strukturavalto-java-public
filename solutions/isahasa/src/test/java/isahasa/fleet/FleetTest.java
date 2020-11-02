package isahasa.fleet;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FleetTest {

    Fleet fleet = new Fleet();

    Liner liner1 = new Liner(100);

    Liner liner2 = new Liner(200);

    CargoShip cargoShip = new CargoShip(50);

    FerryBoat ferryBoat = new FerryBoat(100, 40);

    @BeforeEach
    public void init() {
        fleet.addShip(liner1);
        fleet.addShip(liner2);
        fleet.addShip(cargoShip);
        fleet.addShip(ferryBoat);
    }

    @Test
    public void loadWithoutRemainders() {
        // When
        fleet.loadShip(320, 80);

        // Then
        assertEquals(100, liner1.getPassengers());
        assertEquals(200, liner2.getPassengers());
        assertEquals(20, ferryBoat.getPassengers());
        assertEquals(0, fleet.getWaitingPersons());

        assertEquals(50, cargoShip.getCargoWeight());
        assertEquals(30, ferryBoat.getCargoWeight());

        assertEquals(0, fleet.getWaitingCargo());
    }

    @Test
    public void loadWithRemainders() {
        // When
        fleet.loadShip(350, 170);

        // Then
        assertEquals(100, liner1.getPassengers());
        assertEquals(200, liner2.getPassengers());
        assertEquals(40, ferryBoat.getPassengers());
        assertEquals(10, fleet.getWaitingPersons());

        assertEquals(50, cargoShip.getCargoWeight());
        assertEquals(100, ferryBoat.getCargoWeight());

        assertEquals(20, fleet.getWaitingCargo());
    }
}