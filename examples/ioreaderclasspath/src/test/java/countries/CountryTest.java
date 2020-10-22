package countries;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountryTest {

    private Country c = new Country("Hungary",7);


    @Test
    public void createCountryTest(){
        assertEquals("Hungary",c.getName());
        assertEquals(7,c.getBorderCountries());
    }

}
