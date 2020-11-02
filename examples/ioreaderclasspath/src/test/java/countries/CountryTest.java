package countries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {

    private Country c = new Country("Hungary", 7);


    @Test
    public void createCountryTest() {
        assertEquals("Hungary", c.getName());
        assertEquals(7, c.getBorderCountries());
    }

}
