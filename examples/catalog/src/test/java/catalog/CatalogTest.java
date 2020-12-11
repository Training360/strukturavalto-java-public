package catalog;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static catalog.SearchCriteria.createByBoth;
import static catalog.SearchCriteria.createByContributor;
import static catalog.SearchCriteria.createByTitle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CatalogTest {


    public CatalogItem catalogItem1 = new CatalogItem("R-1", 300,
            new AudioFeatures("Night Visions", 185, Arrays.asList("Dan Raynolds"), Arrays.asList("Imagine Dragons")),
            new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling")),
            new AudioFeatures("Piece of Mind", 200, Arrays.asList("Steve Harris"), Arrays.asList("Iron Maiden"))

    );

    public CatalogItem catalogItem2 = new CatalogItem("R- 2", 300,
            new PrintedFeatures("Harry Potter", 500, Arrays.asList("J.K. Rowling"))
    );


    public CatalogItem catalogItem3 = new CatalogItem("R-3", 300,
            new AudioFeatures("Californication", 100, Arrays.asList("Flea"), Arrays.asList("RHCP"))
    );

    public Catalog catalog = new Catalog();


    @Test
    public void testAddAndDeleteItem() {
        assertEquals(0, catalog.catalogItems.size());
        catalog.addItem(catalogItem1);
        assertEquals(1, catalog.catalogItems.size());
        catalog.deleteItemByRegistrationNumber("R-1");
        assertEquals(0, catalog.catalogItems.size());

    }

    @Test
    public void testGetAudioLibraryItems() {

        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);

        assertEquals(1, catalog.getAudioLibraryItems().size());

    }

    @Test
    public void testGetPrintedLibraryItems() {

        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);

        assertEquals(2, catalog.getPrintedLibraryItems().size());
    }

    @Test
    public void testGetAllPageNumber() {

        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);

        assertEquals(1100, catalog.getAllPageNumber());

    }

    @Test
    public void testGetFullLength() {

        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);

        assertEquals(485, catalog.getFullLength());
    }

    @Test
    public void testAveragePageWithIllegalArgument() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);

        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            catalog.averagePageNumberOver(0);
        });
        assertEquals("Page number must be positive", actualException.getMessage());
    }

    @Test
    public void testAveragePageWithZero() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);

        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            catalog.averagePageNumberOver(10000);
        });
        assertEquals("No page", actualException.getMessage());
    }

    @Test
    public void testAveragePageNumberOverVariable() {
        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);
        catalog.addItem(catalogItem3);

        assertEquals(550.0, catalog.averagePageNumberOver(100));
        assertEquals(600.0, catalog.averagePageNumberOver(501));

    }

    @Test
    public void testFindByCriteriaBoth() {

        SearchCriteria searchCriteria = createByBoth("Night Visions", "Dan Raynolds");


        catalog.addItem(catalogItem1);
        catalog.addItem(catalogItem2);

        assertEquals(1, catalog.findByCriteria(searchCriteria).size());
        assertEquals("Night Visions", catalog.findByCriteria(searchCriteria).get(0).getFeatures().get(0).getTitle());

    }

    @Test
    public void testFindByCriteriaContributor() {


        SearchCriteria searchCriteria = createByContributor("Imagine Dragons");


        catalog.addItem(catalogItem1);

        assertEquals(1, catalog.findByCriteria(searchCriteria).size());

    }

    @Test
    public void testFindByCriteriaTitle() {

        SearchCriteria searchCriteria = createByTitle("Harry Potter");


        catalog.addItem(catalogItem1);

        assertEquals(1, catalog.findByCriteria(searchCriteria).size());

    }

}
