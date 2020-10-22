package isahasa.fleet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LinerTest {

	@Test
	public void load() {
		Liner liner = new Liner(100);

		assertThat(liner.loadPassenger(56), is(0));
		assertThat(liner.getPassengers(), is(56));
	}

	@Test
	public void loadToMuch() {
		Liner liner = new Liner(100);

		assertThat(liner.loadPassenger(111), is(11));
		assertThat(liner.getPassengers(), is(100));
	}
}