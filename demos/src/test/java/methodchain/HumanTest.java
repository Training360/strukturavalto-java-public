package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumanTest {
	@Test
	public void testPetSetter() throws Exception {
		final String petName = "bodri";

		Human human = new Human("noname");
		Human human2 = human.setPet(petName);

		assertEquals("noname", human.getName());
		assertTrue(human == human2);
		assertEquals(petName, human.getPet());
	}

	@Test
	public void testFavouriteCarSetter() throws Exception {
		final String favouriteCar = "alfa";

		Human human = new Human("noname");
		Human human2 = human.setFavouriteCar(favouriteCar);

		assertTrue(human == human2);
		assertEquals(favouriteCar, human.getFavouriteCar());
	}

	@Test
	public void tesCountOfChildren() throws Exception {
		final int countOfChildren = 5;

		Human human = new Human("noname");
		Human human2 = human.setCountOfChildren(countOfChildren);

		assertTrue(human == human2);
		assertEquals(countOfChildren, human.getCountOfChildren());
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

		assertEquals(countOfChildren, human.getCountOfChildren());
		assertEquals(favouriteCar, human.getFavouriteCar());
		assertEquals(petName, human.getPet());
	}


}