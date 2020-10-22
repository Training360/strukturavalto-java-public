package troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Trooper must not be null.");
        }
        troopers.add(trooper);
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null");
        }
        Trooper closest = findClosestTrooper(target);
        if (closest != null) {
            moveTrooper(closest, target);
        }
    }

    public void moveTrooperByName(String name, Position target) {
        Trooper trooper = findTrooperByName(name);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    private Trooper findClosestTrooper(Position target) {
        if (troopers.isEmpty()) {
            return null;
        }
        Trooper closest = troopers.get(0);
        for (Trooper trooper : troopers) {
            if (trooper.distanceFrom(target) < closest.distanceFrom(target)) {
                closest = trooper;
            }
        }
        return closest;
    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        return null;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
