package virtualmethod.vehicle;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VanTest {
    @Test
    public void getGrossLoad() throws Exception {
        Van van = new Van(1, 1200, 200);

        assertEquals((1 + 1) * Car.PERSON_AVERAGE_WEIGHT + 1200 + 200, van.getGrossLoad());
    }

    @Test
    public void tostring() {
        Van van = new Van(1, 1200, 200);

        assertEquals("Van{cargoWeight=" + 200 + ", numberOfPassenger=" + 1 + ", vehicleWeight=" + 1200 + '}', van.toString());

    }

}