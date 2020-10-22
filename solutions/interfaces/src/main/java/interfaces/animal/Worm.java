package interfaces.animal;

public class Worm implements Animal {

	public static final int NUMBER_OF_LEGS = 0;

	@Override
	public int getNumberOfLegs() {
		return NUMBER_OF_LEGS;
	}

	@Override
	public String getName() {
		return "Worm";
	}
}
