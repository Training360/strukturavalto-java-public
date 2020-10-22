package virtualmethod.vehicle;

public class Car extends Vehicle{
	protected int numberOfPassenger;

	public Car(int vehicleWeight, int numberPassenger) {
		super(vehicleWeight);
		this.numberOfPassenger = numberPassenger;
	}

	@Override
	public int getGrossLoad() {
		return super.getGrossLoad() + numberOfPassenger * PERSON_AVERAGE_WEIGHT;
	}

	@Override
	public String toString() {
		return "Car{" +
				"numberOfPassenger=" + numberOfPassenger +
				", vehicleWeight=" + getVehicleWeight() +
				'}';
	}
}
