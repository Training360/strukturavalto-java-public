package virtualmethod.vehicle;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VehicleTest {
	@Test
	public void getGrossLoad() {
		Vehicle vehicle = new Vehicle(1000);

		assertThat(vehicle.getGrossLoad(), is(1000 + Vehicle.PERSON_AVERAGE_WEIGHT));
	}

	@Test
	public void getVehicleWeight() {
		Vehicle vehicle = new Vehicle(1000);

		assertThat(vehicle.getVehicleWeight(), is(1000 ));
	}

	@Test
	public void tostring() {
		Vehicle vehicle = new Vehicle(1000);

		assertThat(vehicle.toString(), is("Vehicle{vehicleWeight=" + 1000 +'}'));
	}

}