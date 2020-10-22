package isahasa.fleet;

public class Liner implements Ship, CanCarryPassengers {

	private final CanCarryPassengers canCarryPassengers;

	public Liner(int maxPassengers) {
		canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
	}

	public int getPassengers() {
		return canCarryPassengers.getPassengers();
	}

	public int loadPassenger(int passengers){
		return canCarryPassengers.loadPassenger(passengers);
	}

}
