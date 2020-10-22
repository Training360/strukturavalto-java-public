package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
	List<Ship> ships = new ArrayList<>();

	private int waitingPersons;

	private int waitingCargo;

	public void addShip(Ship newShip) {
		ships.add(newShip);
	}

	public void loadShip(int numberOfPersons, int cargoWeight) {
			int remainingPersons = numberOfPersons;
			int remainingCargo = cargoWeight;

			for (Ship ship: ships) {
				if (ship instanceof CanCarryPassengers) {
					if(remainingPersons != 0) {
						remainingPersons = ((CanCarryPassengers) ship).loadPassenger(remainingPersons);
					}
				}
				if (ship instanceof CanCarryGoods) {
					if (remainingCargo != 0) {
						remainingCargo = ((CanCarryGoods) ship).loadCargo(remainingCargo);
					}
				}
			}

			waitingPersons = remainingPersons;
			waitingCargo = remainingCargo;
	}

	public int getWaitingPersons() {
		return waitingPersons;
	}

	public int getWaitingCargo() {
		return waitingCargo;
	}
}
