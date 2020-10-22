package isahasa.fleet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FerryBoatTest {

	@Test
	public void load() {
		FerryBoat ferryBoat = new FerryBoat(1000, 100);
		assertThat(ferryBoat.loadPassenger(56), is(0));
		assertThat(ferryBoat.loadCargo(560), is(0));

		assertThat(ferryBoat.getCargoWeight(), is(560));
		assertThat(ferryBoat.getPassengers(), is(56));
	}

	@Test
	public void loadToMuch() {
		FerryBoat ferryBoat = new FerryBoat(1000, 100);
		assertThat(ferryBoat.loadPassenger(111), is(11));
		assertThat(ferryBoat.loadCargo(1100), is(100));

		assertThat(ferryBoat.getCargoWeight(), is(1000));
		assertThat(ferryBoat.getPassengers(), is(100));
	}
}