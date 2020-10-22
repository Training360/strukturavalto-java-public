package employee;

public class Employee {

    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        if (isEmpty(job)) {
            throw new IllegalArgumentException("Job must not be empty.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
