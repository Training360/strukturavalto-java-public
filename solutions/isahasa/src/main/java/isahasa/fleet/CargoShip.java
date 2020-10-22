package isahasa.fleet;

public class CargoShip implements Ship, CanCarryGoods {
	private final CanCarryGoods canCarryGoods;

	public CargoShip(int maxCargoWeight) {
		canCarryGoods = new CanCarryGoodsBehaviour(maxCargoWeight);
	}

	public int loadCargo(int cargoWeight){
		return canCarryGoods.loadCargo(cargoWeight);
	}

	public int getCargoWeight() {
		return canCarryGoods.getCargoWeight();
	}

}
