package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();


    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public List<String> getStatus() {
        return fishes.stream().map(Fish::getStatus).collect(Collectors.toList());
    }

    public void feed() {
        fishes.forEach(Fish::feed);
    }

    public void removeFish() {
        fishes.removeIf(fish -> fish.getWeight() >= 11);
    }
}
