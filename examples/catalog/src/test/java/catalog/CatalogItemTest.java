package catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CatalogItemTest {

    CatalogItem catalogItem = new CatalogItem("R-1", 300,
            new AudioFeatures("Night Visions", 185, Arrays.asList("Dan Raynolds"), Arrays.asList("Imagine Dragons")),
            new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling")),
            new AudioFeatures("Piece of Mind", 200, Arrays.asList("Steve Harris"), Arrays.asList("Iron Maiden"))
    );


    CatalogItem catalogItem2 = new CatalogItem("R-2", 300,
            new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling"))
    );


    @Test
    public void testGetFeaturesGetAudioContributors() {

        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds");

        assertEquals(result, catalogItem.getFeatures().get(0).getContributors());

    }

    @Test
    public void testGetFeaturesGetPrintedContributors() {

        List<String> result = Arrays.asList("J.K. Rowling");

        assertEquals(result, catalogItem.getFeatures().get(1).getContributors());

    }

    @Test
    public void testCreate() {
        assertEquals(300, catalogItem.getPrice());
        assertEquals("R-1", catalogItem.getRegistrationNumber());

    }

    @Test
    public void testNumberOfPagesAtOneItem() {
        assertEquals(600, catalogItem.numberOfPagesAtOneItem());
    }

    @Test
    public void testFullLengthAtOneItem() {
        assertEquals(385, catalogItem.fullLengthAtOneItem());
    }

    @Test
    public void testGetAllContributorsFromOneItem() {
        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds", "J.K. Rowling", "Iron Maiden", "Steve Harris");
        assertEquals(result, catalogItem.getContributors());
    }

    @Test
    public void testGetTitlesFromAllFeature() {
        List<String> result = Arrays.asList("Night Visions", "Harry Potter", "Piece of Mind");
        assertEquals(result, catalogItem.getTitles());
    }

    @Test
    public void testHasAudioFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertFalse(catalogItem2.hasAudioFeature());
    }

    @Test
    public void testHasPrintedFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertTrue(catalogItem2.hasPrintedFeature());
    }


}
