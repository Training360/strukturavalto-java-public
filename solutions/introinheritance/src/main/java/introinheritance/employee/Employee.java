package introinheritance.employee;

public class Employee extends Person {
    
    private double salary;

    public Employee(String name, String address, double salary) {
        super(name, address);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(int percent) {
        this.salary += this.salary * (1.0 * percent / 100);
    }
}
