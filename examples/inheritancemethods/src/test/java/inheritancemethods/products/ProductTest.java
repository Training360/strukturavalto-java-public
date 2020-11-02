package inheritancemethods.products;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {

    @Test
    public void constructorTest3Parameters() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit, 3);
        //Then
        assertEquals("Ipad", product.getName());
        assertEquals(unit, product.getUnitWeight());
        assertEquals(3, product.getNumberOfDecimals());
    }

    @Test
    public void constructorTest2Parameters() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit);
        //Then
        assertEquals("Ipad", product.getName());
        assertEquals(unit, product.getUnitWeight());
        assertEquals(2, product.getNumberOfDecimals());
    }

    @Test
    public void totalWeight() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        Product product = new Product("Ipad", unit, 3);
        BigDecimal total = new BigDecimal("0.705");
        //Then
        assertEquals(total, product.totalWeight(3));
    }
}