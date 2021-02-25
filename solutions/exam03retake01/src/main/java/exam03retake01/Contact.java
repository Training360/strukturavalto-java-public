package exam03retake01;

public class Contact {

    private String name;

    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean match(String s) {
        return name.equals(s) || email.equals(s);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
