package inheritancemethods.products;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProductTest {

    @Test
    public void constructorTest3Parameters() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit, 3);
        //Then
        assertThat(product.getName(), equalTo("Ipad"));
        assertThat(product.getUnitWeight(), equalTo(unit));
        assertThat(product.getNumberOfDecimals(), equalTo(3));
    }

    @Test
    public void constructorTest2Parameters() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit);
        //Then
        assertThat(product.getName(), equalTo("Ipad"));
        assertThat(product.getUnitWeight(), equalTo(unit));
        assertThat(product.getNumberOfDecimals(), equalTo(2));
    }

    @Test
    public void totalWeight() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit, 3);
        BigDecimal total = new BigDecimal("0.705");
        //Then
        assertThat(product.totalWeight(3), equalTo(total));
    }
}