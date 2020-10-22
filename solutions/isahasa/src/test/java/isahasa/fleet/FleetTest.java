package isahasa.fleet;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FleetTest {

    Fleet fleet = new Fleet();

    Liner liner1 = new Liner(100);

    Liner liner2 = new Liner(200);

    CargoShip cargoShip = new CargoShip(50);

    FerryBoat ferryBoat = new FerryBoat(100, 40);

    @Before
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
        assertThat(liner1.getPassengers(), is(100));
        assertThat(liner2.getPassengers(), is(200));
        assertThat(ferryBoat.getPassengers(), is(20));
        assertThat(fleet.getWaitingPersons(), is(0));

        assertThat(cargoShip.getCargoWeight(), is(50));
        assertThat(ferryBoat.getCargoWeight(), is(30));

        assertThat(fleet.getWaitingCargo(), is(0));
    }

	@Test
	public void loadWithRemainders() {
		// When
		fleet.loadShip(350, 170);

		// Then
		assertThat(liner1.getPassengers(), is(100));
		assertThat(liner2.getPassengers(), is(200));
        assertThat(ferryBoat.getPassengers(), is(40));
        assertThat(fleet.getWaitingPersons(), is(10));

        assertThat(cargoShip.getCargoWeight(), is(50));
        assertThat(ferryBoat.getCargoWeight(), is(100));

        assertThat(fleet.getWaitingCargo(), is(20));
	}
}