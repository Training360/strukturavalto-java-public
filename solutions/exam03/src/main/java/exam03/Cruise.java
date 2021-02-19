package exam03;

import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;

    private LocalDate sailing;

    private double basicPrice;

    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.getMaxPassengers() <= passengers.size()) {
            throw new IllegalArgumentException("Too many passengers");
        }
        passengers.add(passenger);
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplier() * basicPrice;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger: passengers) {
            if (passenger.getName().equals(name)) {
                return passenger;
            }
        }
        throw new IllegalArgumentException("Not found with name: " + name);
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> names = new ArrayList<>();
        for (Passenger passenger: passengers) {
            names.add(passenger.getName());
        }
        Collections.sort(names, Collator.getInstance(new Locale("hu", "HU")));
        return names;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger: passengers) {
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> counts = new HashMap<>();
        for (Passenger passenger: passengers) {
            if (!counts.containsKey(passenger.getCruiseClass())) {
                counts.put(passenger.getCruiseClass(), 1);
            }
            else {
                counts.put(passenger.getCruiseClass(), counts.get(passenger.getCruiseClass()) + 1);
            }
        }
        return counts;
    }
}
