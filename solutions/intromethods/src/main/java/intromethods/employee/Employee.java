package intromethods.employee;

public class Employee {

    private String name;

    private int hiringYear;

    private int salary;

    public Employee(String name, int hiringYear, int salary) {
        this.name = name;
        this.hiringYear = hiringYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHiringYear() {
        return hiringYear;
    }

    public int getSalary() {
        return salary;
    }

    public void raiseSalary(int amount) {
        salary += amount;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", hiringYear=" + hiringYear +
            ", salary=" + salary +
            '}';
    }
}
