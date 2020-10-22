package introdate;

public class EmployeeTest {

    public static void main(String[] args) {

        Employee employee = new Employee(1992, 2, 2, "Kovács Béla");
        System.out.println(employee.getBeginEmployment());
        System.out.println(employee.getDateOfBirth());
    }
}
