package interfacedependencyinversion;

public class FixedBonusCalculator implements BonusCalculator {

    @Override
    public int calculateBonus(int salary) {
        return salary + 10_000;
    }
}
