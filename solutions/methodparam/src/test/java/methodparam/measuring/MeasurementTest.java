package methodparam.measuring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MeasurementTest {

    private Measurement measurement;

    @Before
    public void setUp() {
        double[] values = new double[] {10, 4, 3, 8, 12, 5, 7};
        this.measurement = new Measurement(values);
    }

    @After
    public void tearDown(){
        this.measurement = null;
    }

    @Test
    public void findFirstIndexInLimit() {
        assertThat(this.measurement.findFirstIndexInLimit(4, 8), equalTo(5));
        assertThat(this.measurement.findFirstIndexInLimit(0, 2), equalTo(-1));
    }

    @Test
    public void minimum() {
        assertThat(this.measurement.minimum(), equalTo(3.0));
    }

    @Test
    public void maximum() {
        assertThat(this.measurement.maximum(), equalTo(12.0));
    }

    @Test
    public void minmax() {
        ExtremValues extremValues = this.measurement.minmax();

        assertThat(extremValues.getMin(), equalTo(3.0));
        assertThat(extremValues.getMax(), equalTo(12.0));
    }
}