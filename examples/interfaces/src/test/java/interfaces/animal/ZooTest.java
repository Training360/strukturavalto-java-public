package interfaces.animal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ZooTest {

	@Test
	public void getNumberOfLegsWithEmptyList() {
		List<Animal> animals = new ArrayList<>();
		Zoo zoo = new Zoo(animals);

		assertThat(zoo.getNumberOfLegs(), is(0));
	}

	@Test
	public void getNumberOfLegsWithAList() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Duck());
		animals.add(new Worm());
		animals.add(new Duck());
		animals.add(new Lion());
		Zoo zoo = new Zoo(animals);

		assertThat(zoo.getNumberOfLegs(), is(8));
	}

	@Test
	public void getNumberOfAnimals() {
		List<Animal> animals = new ArrayList<>();
		animals.add(new Duck());
		animals.add(new Worm());
		animals.add(new Duck());
		animals.add(new Lion());
		Zoo zoo = new Zoo(animals);

		assertThat(zoo.getNumberOfAnimals(), is(4));
	}
}