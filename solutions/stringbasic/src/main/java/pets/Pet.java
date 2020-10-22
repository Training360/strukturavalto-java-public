package pets;

import java.time.LocalDate;

public class Pet {

    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String registrationNumber;

    public Pet(String name, LocalDate dateOfBirth, Gender gender, String registrationNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
