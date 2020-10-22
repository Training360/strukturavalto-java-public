package methodchain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

public class HumanTest {
	@Test
	public void testPetSetter() throws Exception {
		final String petName = "bodri";

		Human human = new Human("noname");
		Human human2 = human.setPet(petName);

		assertThat(human.getName(), equalTo("noname"));
		assertThat(human, is(sameInstance(human2)));
		assertThat(human.getPet(), equalTo(petName));
	}

	@Test
	public void testFavouriteCarSetter() throws Exception {
		final String favouriteCar = "alfa";

		Human human = new Human("noname");
		Human human2 = human.setFavouriteCar(favouriteCar);

		assertThat(human, is(sameInstance(human2)));
		assertThat(human.getFavouriteCar(), equalTo(favouriteCar));
	}

	@Test
	public void tesCountOfChildren() throws Exception {
		final int countOfChildren = 5;

		Human human = new Human("noname");
		Human human2 = human.setCountOfChildren(countOfChildren);

		assertThat(human, is(sameInstance(human2)));
		assertThat(human.getCountOfChildren(), equalTo(countOfChildren));
	}

	@Test
	public void testCallingChain() throws Exception {
		final String petName = "bodri";
		final String favouriteCar = "alfa";
		final int countOfChildren = 5;
		Human human = new Human("noname");

		human.setPet(petName)
				.setCountOfChildren(countOfChildren)
				.setFavouriteCar(favouriteCar);

		assertThat(human.getCountOfChildren(), equalTo(countOfChildren));
		assertThat(human.getFavouriteCar(), equalTo(favouriteCar));
		assertThat(human.getPet(), equalTo(petName));
	}


}