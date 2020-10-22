package lambdaprimitives;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SportGadgetStoreTest {

    private List<Product> products;

    @Before
    public void initProducts(){
        products = new ArrayList<>();
        products.add(new Product("Tennis ball", 2.47, 138));
        products.add(new Product("Tennis racket", 29.9, 23));
        products.add(new Product("Running shoes", 57.0,16));
        products.add(new Product("Fitness banch", 215.0, 7));
        products.add(new Product("Threadmill", 997.0,4));
        products.add(new Product("Punching bag", 539.9,3));
        products.add(new Product("Snowboard", 149.0, 12));
        products.add(new Product("Golf ball", 29.99, 64));
        products.add(new Product("Golf club", 127.99,19));
        products.add(new Product("Mountain bike", 179.0, 5));
    }

    @Test
    public void getNumberOfProducts(){
        SportGadgetStore store = new SportGadgetStore(products);

        assertThat(store.getNumberOfProducts(), is(291));
    }

    @Test
    public void getNumberOfProductsForEmptyList(){
        SportGadgetStore store = new SportGadgetStore(Collections.EMPTY_LIST);

        assertThat(store.getNumberOfProducts(), is(0));
    }

    @Test
    public void getAveragePrice() {
        SportGadgetStore store = new SportGadgetStore(products);

        assertThat(store.getAveragePrice(), is(232.725));
    }

    @Test
    public void getAveragePriceForEmptyList() {
        SportGadgetStore store = new SportGadgetStore(Collections.EMPTY_LIST);

        assertThat(store.getAveragePrice(), is(0.0));
    }

    @Test
    public void getExpensiveProductStatistics() {
        SportGadgetStore store = new SportGadgetStore(products);
        String expectedString = "Összesen 6 féle termék, amelyekből minimum 3 db, maximum 19 db, összesen 50 db van.";

        assertThat(store.getExpensiveProductStatistics(100.0), equalTo(expectedString));
    }

    @Test
    public void getExpensiveProductStatisticsForEmptyList() {
        SportGadgetStore store = new SportGadgetStore(Collections.EMPTY_LIST);

        assertThat(store.getExpensiveProductStatistics(100.0), equalTo("Nincs ilyen termék."));
    }

    @Test
    public void getExpensiveProductStatisticsWithZeroProduct() {
        SportGadgetStore store = new SportGadgetStore(Arrays.asList(new Product("Tennis ball", 2.47, 138)));

        assertThat(store.getExpensiveProductStatistics(100.0), equalTo("Nincs ilyen termék."));
    }
}
