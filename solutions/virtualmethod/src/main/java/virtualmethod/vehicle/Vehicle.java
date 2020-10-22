package virtualmethod.vehicle;

public class Vehicle {
	private int vehicleWeight;
	public static int PERSON_AVERAGE_WEIGHT = 75;

	public Vehicle(int vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}

	public int getGrossLoad() {
		return vehicleWeight + PERSON_AVERAGE_WEIGHT;
	}

	public int getVehicleWeight() {
		return vehicleWeight;
	}

	@Override
	public String toString() {
		return "Vehicle{" +
				"vehicleWeight=" + vehicleWeight +
				'}';
	}
}
