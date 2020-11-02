package virtualmethod.vehicle;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FerryBoatTest {
    @Test
    public void canCarryTrue() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(1200, 0);

        assertTrue(ferryBoat.canCarry(car));

        car = new Van(1, 1200, 200);

        assertTrue(ferryBoat.canCarry(car));

    }

    @Test
    public void canCarryFalse() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(2000, 0);

        assertFalse(ferryBoat.canCarry(car));

        car = new Van(1, 2000, 200);

        assertFalse(ferryBoat.canCarry(car));
    }

    @Test
    public void loadSuccess() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(1200, 0);

        assertTrue(ferryBoat.load(car));
    }

    @Test
    public void loadFailed() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(2000, 0);

        assertFalse(ferryBoat.load(car));
    }

    @Test
    public void getGrossLoad() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(1234, 0);

        ferryBoat.load(car);

        assertEquals(2000 + FerryBoat.PERSON_AVERAGE_WEIGHT + car.getGrossLoad(), ferryBoat.getGrossLoad());
    }

    @Test
    public void toStringCar() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Car car = new Car(1234, 0);

        ferryBoat.load(car);

        assertEquals("FerryBoat{" +
                "car=" +
                "Car{numberOfPassenger=" + 0 + ", vehicleWeight=" + 1234 + '}' +
                '}', ferryBoat.toString());
    }

    @Test
    public void toStringVan() {
        FerryBoat ferryBoat = new FerryBoat(2000);
        Van van = new Van(1, 1200, 200);

        ferryBoat.load(van);

        assertEquals("FerryBoat{car=Van{cargoWeight=" + 200 + ", numberOfPassenger=" + 1 + ", vehicleWeight=" + 1200 + "}}", ferryBoat.toString());

    }

}