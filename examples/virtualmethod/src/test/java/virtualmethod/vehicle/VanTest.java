package virtualmethod.vehicle;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class VanTest {
	@Test
	public void getGrossLoad() throws Exception {
		Van van = new Van(1, 1200, 200);

		assertThat(van.getGrossLoad() , is((1 + 1) * Car.PERSON_AVERAGE_WEIGHT + 1200 + 200));
	}

	@Test
	public void tostring() {
		Van van = new Van(1, 1200, 200);

		assertThat(van.toString(),
				is("Van{cargoWeight=" + 200 + ", numberOfPassenger=" + 1 + ", vehicleWeight=" + 1200 +'}'));
	}

}