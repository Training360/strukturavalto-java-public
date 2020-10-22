package isahasa.fleet;

public class FerryBoat implements CanCarryGoods, CanCarryPassengers, Ship{
	private final CanCarryGoods canCarryGoods;
	private final CanCarryPassengers canCarryPassengers;

	public FerryBoat(int maxCargoWeight, int maxPassengers) {
		canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
		canCarryPassengers = new CanCarryPassengersBehaviour(maxPassengers);
	}

	@Override
	public int loadCargo(int cargoWeight){
		return canCarryGoods.loadCargo(cargoWeight);
	}

	public int getCargoWeight() {
		return canCarryGoods.getCargoWeight();
	}

	public int getPassengers() {
		return canCarryPassengers.getPassengers();
	}

	@Override
	public int loadPassenger(int passengers){
		return canCarryPassengers.loadPassenger(passengers);
	}

}
