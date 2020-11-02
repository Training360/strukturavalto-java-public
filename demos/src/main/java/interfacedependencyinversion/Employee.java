package interfacedependencyinversion;

public class Employee {

    private int salary;

    private BonusCalculator bonusCalculator;

    public Employee(int salary, BonusCalculator bonusCalculator) {
        this.salary = salary;
        this.bonusCalculator = bonusCalculator;
    }

    public int getBonus() {
        return bonusCalculator.calculateBonus(salary);
    }
}
