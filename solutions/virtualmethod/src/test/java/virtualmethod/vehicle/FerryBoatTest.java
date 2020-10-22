package virtualmethod.vehicle;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FerryBoatTest {
	@Test
	public void canCarryTrue() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(1200, 0);

		assertThat(ferryBoat.canCarry(car) , is(true));

		car = new Van(1, 1200, 200);

		assertThat(ferryBoat.canCarry(car) , is(true));
	}

	@Test
	public void canCarryFalse() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(2000, 0);

		assertThat(ferryBoat.canCarry(car) , is(false));

		car = new Van(1, 2000, 200);

		assertThat(ferryBoat.canCarry(car) , is(false));
	}

	@Test
	public void loadSuccess() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(1200, 0);

		assertThat(ferryBoat.load(car) , is(true));
	}

	@Test
	public void loadFailed() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(2000, 0);

		assertThat(ferryBoat.load(car) , is(false));
	}

	@Test
	public void getGrossLoad() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(1234, 0);

		ferryBoat.load(car);

		assertThat(ferryBoat.getGrossLoad() , is(2000 + FerryBoat.PERSON_AVERAGE_WEIGHT + car.getGrossLoad()));
	}

	@Test
	public void toStringCar() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Car car = new Car(1234, 0);

		ferryBoat.load(car);

		assertThat(ferryBoat.toString(),
				is("FerryBoat{" +
						"car=" +
						"Car{numberOfPassenger=" + 0 + ", vehicleWeight=" + 1234 +'}' +
						'}')
		);
	}

	@Test
	public void toStringVan() {
		FerryBoat ferryBoat = new FerryBoat(2000);
		Van van = new Van(1, 1200, 200);

		ferryBoat.load(van);

		assertThat(ferryBoat.toString(),
				is("FerryBoat{car=Van{cargoWeight=" + 200 + ", numberOfPassenger=" + 1 + ", vehicleWeight=" + 1200 +"}}")
		);

	}

}