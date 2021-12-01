package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<MilitaryUnit> militaryUnits;

    public Army() {
        this.militaryUnits = new ArrayList<>();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
    }

    public void damageAll(int damage) {
        militaryUnits.forEach(militaryUnit -> militaryUnit.sufferDamage(damage));
        militaryUnits.removeIf(militaryUnit -> militaryUnit.getHitPoints() < 25);
    }

    public int getArmyDamage() {
        int armyDamage = 0;
        for (MilitaryUnit militaryUnit : militaryUnits) {
            armyDamage += militaryUnit.doDamage();
        }
        return armyDamage;
    }

    public int getArmySize() {
        return militaryUnits.size();
    }
}
