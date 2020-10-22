package interfaces.animal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DuckTest {
	@Test
	public void getNumberofLegs() throws Exception {
		Duck duck = new Duck();

		assertThat(duck.getNumberOfLegs(), is(2));
	}

	@Test
	public void getName() throws Exception {
		Duck duck = new Duck();

		assertThat(duck.getName(), is("Duck"));
	}

}