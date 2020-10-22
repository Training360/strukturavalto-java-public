package interfaces.animal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WormTest {
	@Test
	public void getNumberofLegs() {
		Worm worm = new Worm();

		assertThat(worm.getNumberOfLegs(), is(0));
	}

	@Test
	public void getName() {
		Worm worm = new Worm();

		assertThat(worm.getName(), is("Worm"));
	}

}