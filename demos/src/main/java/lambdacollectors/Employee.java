package lambdacollectors;

public class Employee {

    private Long id;

    private String name;

    private int salary;

    private String division;

    public Employee(Long id, String name, int salary, String division) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
