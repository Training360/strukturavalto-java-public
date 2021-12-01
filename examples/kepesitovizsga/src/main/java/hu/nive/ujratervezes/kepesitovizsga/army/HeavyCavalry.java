package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    boolean canCharge;

    public HeavyCavalry() {
        super(150, 20, true);
        canCharge = true;
    }

    @Override
    public int doDamage() {
        int damage = this.damage;
        if (canCharge) {
            damage *= 3;
            canCharge = false;
        }
        return damage;
    }
}
