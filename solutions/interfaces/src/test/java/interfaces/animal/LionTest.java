package interfaces.animal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LionTest {
	@Test
	public void getNumberofLegs() {
		Lion lion = new Lion();
		assertThat(lion.getNumberOfLegs(), is(4));
	}

	@Test
	public void getName() {
		Lion lion = new Lion();
		assertThat(lion.getName(), is("Lion"));
	}

}