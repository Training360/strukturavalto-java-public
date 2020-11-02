package methodparam.measuring;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasurementTest {

    private Measurement measurement;

    @BeforeEach
    public void setUp() {
        double[] values = new double[]{10, 4, 3, 8, 12, 5, 7};
        this.measurement = new Measurement(values);
    }

    @AfterEach
    public void tearDown() {
        this.measurement = null;
    }

    @Test
    public void findFirstIndexInLimit() {
        assertEquals(5, this.measurement.findFirstIndexInLimit(4, 8));
        assertEquals(-1, this.measurement.findFirstIndexInLimit(0, 2));
    }

    @Test
    public void minimum() {
        assertEquals(3.0, this.measurement.minimum());
    }

    @Test
    public void maximum() {
        assertEquals(12.0, this.measurement.maximum());
    }

    @Test
    public void minmax() {
        ExtremValues extremValues = this.measurement.minmax();

        assertEquals(3.0, extremValues.getMin());
        assertEquals(12.0, extremValues.getMax());
    }
}