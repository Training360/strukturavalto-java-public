package inheritancemethods.products;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PackedProductTest {

    @Test
    public void constructorTest() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        BigDecimal box = new BigDecimal("1.25");
        PackedProduct product = new PackedProduct("Ipad", unit, 3, 12, box);
        //Then
        assertThat(product.getName(), equalTo("Ipad"));
        assertThat(product.getUnitWeight(), equalTo(unit));
        assertThat(product.getNumberOfDecimals(), equalTo(3));
        assertThat(product.getPackingUnit(), equalTo(12));
        assertThat(product.getWeightOfBox(), equalTo(box));
    }

    @Test
    public void totalWeight() {
        //Given
        BigDecimal unit = new BigDecimal("0.235");
        BigDecimal box = new BigDecimal("1.25");
        PackedProduct product = new PackedProduct("Ipad", unit, 3, 12, box);
        BigDecimal total = new BigDecimal("6.025");
        //Then
        assertThat(product.totalWeight(15), equalTo(total));
    }
}