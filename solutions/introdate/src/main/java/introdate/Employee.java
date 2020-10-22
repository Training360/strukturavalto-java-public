package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Employee {

    private LocalDate dateOfBirth;
    private String name;
    private LocalDateTime beginEmployment;

    public Employee(int year, int month, int day, String name) {
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.name = name;
        this.beginEmployment = LocalDateTime.now();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }

    public void setName(String name) {
        this.name = name;
    }
}
