package inheritancemethods.products;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PackedProductTest {

    @Test
    public void constructorTest() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        BigDecimal box = new BigDecimal("1.25");
        PackedProduct product = new PackedProduct("Ipad", unit, 3, 12, box);
        //Then
        assertEquals("Ipad", product.getName());
        assertEquals(unit, product.getUnitWeight());
        assertEquals(3, product.getNumberOfDecimals());
        assertEquals(12, product.getPackingUnit());
        assertEquals(box, product.getWeightOfBox());
    }

    @Test
    public void totalWeight() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        BigDecimal box = new BigDecimal("1.25");
        PackedProduct product = new PackedProduct("Ipad", unit, 3, 12, box);
        BigDecimal total = new BigDecimal("6.025");
        //Then
        assertEquals(total, product.totalWeight(15));
    }
}