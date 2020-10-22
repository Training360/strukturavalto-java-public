package countries;

public class Country {

    private String name;
    private int borderCountries;


    public Country(String name, int borderCountries) {
        this.name = name;
        this.borderCountries = borderCountries;
    }


    public String getName() {
        return name;
    }

    public int getBorderCountries() {
        return borderCountries;
    }
}
