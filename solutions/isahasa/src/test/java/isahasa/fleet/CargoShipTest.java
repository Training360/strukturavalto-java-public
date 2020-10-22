package isahasa.fleet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CargoShipTest {
	@Test
	public void load() {
		// Given
		CargoShip cargoShip = new CargoShip(100);
		assertThat(cargoShip.getCargoWeight(), is(0));

		// When
		int remainder = cargoShip.loadCargo(56);

		// Then
		assertThat(remainder, is(0));
		assertThat(cargoShip.getCargoWeight(), is(56));
	}

	@Test
	public void loadToMuch() {
		// Given
		CargoShip cargoShip = new CargoShip(100);
		assertThat(cargoShip.getCargoWeight(), is(0));

		// When
		int remainder = cargoShip.loadCargo(111);

		// Then
		assertThat(remainder, is(11));
		assertThat(cargoShip.getCargoWeight(), is(100));
	}
}