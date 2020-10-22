package interfaces.animal;

import java.util.List;

public class Zoo {
	private List<Animal> animals;

	public Zoo(List<Animal> animals) {
		this.animals = animals;
	}

	public int getNumberOfLegs() {
		int legs = 0;
		for (Animal animal : animals) {
			legs += animal.getNumberOfLegs();
		}
		return legs;
	}

	public int getNumberOfAnimals() {
		return animals.size();
	}
}
