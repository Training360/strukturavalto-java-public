package lambdaprimitives;

public class Employee {

    private String name;

    private int salary;

    private String cardNumber;

    public Employee(String name, int salary, String cardNumber) {
        this.name = name;
        this.salary = salary;
        this.cardNumber = cardNumber;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
