package hu.nive.ujratervezes.zarovizsga.people;

public class Person {


    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ip;

    public Person(long id, String firstName, String lastName, String email, String gender, String ip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ip = ip;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getIp() {
        return ip;
    }
}
