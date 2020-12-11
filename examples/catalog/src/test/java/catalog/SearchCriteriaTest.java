package catalog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCriteriaTest {

    @Test
    public void testCreateByTitle() {
        SearchCriteria searchCriteria = SearchCriteria.createByTitle("Imagine Dragons");
        assertEquals("Imagine Dragons", searchCriteria.getTitle());
        assertTrue(searchCriteria.hasTitle());
        assertFalse(searchCriteria.hasContributor());
    }

    @Test
    public void testCreateByContributor() {
        SearchCriteria searchCriteria = SearchCriteria.createByContributor("Metallica");
        assertEquals("Metallica", searchCriteria.getContributor());
        assertFalse(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    public void testCreateByBoth() {
        SearchCriteria searchCriteria = SearchCriteria.createByBoth("Ride the Lightning", "Metallica");
        assertEquals("Ride the Lightning", searchCriteria.getTitle());
        assertEquals("Metallica", searchCriteria.getContributor());
        assertTrue(searchCriteria.hasTitle());
        assertTrue(searchCriteria.hasContributor());
    }

    @Test
    public void testInvalidTitle() {

        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByTitle(null);
        });
    }

    @Test
    public void testInvalidContributor() {
        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByContributor(null);
        });
    }

    @Test
    public void testInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            SearchCriteria.createByBoth(null, "Metallica");
        });
    }
}
