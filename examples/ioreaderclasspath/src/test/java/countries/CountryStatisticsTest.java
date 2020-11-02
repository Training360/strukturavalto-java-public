package countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryStatisticsTest {


    private CountryStatistics countryStatistics = new CountryStatistics();


    @Test
    public void createListTest() {
        assertEquals(0, countryStatistics.getCountryList().size());

        countryStatistics.getCountryList().add(new Country("Test", 3));

        assertEquals(0, countryStatistics.getCountryList().size());
    }


    @Test
    public void readFromFileTest() {
        assertEquals(countryStatistics.getCountryList().size(), 0);
        countryStatistics.readFromFile("country.txt");

        assertEquals(8, countryStatistics.getCountryList().size());

        assertEquals("Austria", countryStatistics.getCountryList().get(1).getName());
        assertEquals(1, countryStatistics.getCountryList().get(5).getBorderCountries());
    }

    @Test
    public void numberOfCountriesTest() {
        assertEquals(0, countryStatistics.numberOFCountries());
        countryStatistics.readFromFile("country.txt");

        assertEquals(8, countryStatistics.numberOFCountries());
    }


    @Test
    public void mostBorderCountriesTest() {
        countryStatistics.readFromFile("country.txt");

        assertEquals("Germany", countryStatistics.mostBorderCountries().getName());
        assertEquals(8, countryStatistics.mostBorderCountries().getBorderCountries());

    }
}
