package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean hasShield;

    public Swordsman(boolean hasArmor) {
        super(100, 10, hasArmor);
        hasShield = true;
    }

    @Override
    public void sufferDamage(int damage) {
        if (hasShield) {
            hasShield = false;
        } else {
            super.sufferDamage(damage);
        }
    }
}
