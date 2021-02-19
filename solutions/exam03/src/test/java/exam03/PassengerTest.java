package exam03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassengerTest {

    @Test
    void create() {
        Passenger passenger = new Passenger("John Doe", CruiseClass.LUXURY);
        assertEquals("John Doe", passenger.getName());
        assertEquals(CruiseClass.LUXURY, passenger.getCruiseClass());
    }
}
