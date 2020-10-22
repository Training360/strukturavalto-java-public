package methodstructure.bmi;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BodyMassTest {

    private static final double SAMPLE_MASS = 70;
    private static final double SAMPLE_HEIGHT = 1.7;
    private static final double SAMPLE_MASS_UNDER = 60;
    private static final double SAMPLE_HEIGHT_UNDER = 1.9;
    private static final double SAMPLE_MASS_OVER = 90;
    private static final double SAMPLE_HEIGHT_OVER = 1.6;

    @Test
    public void constructorShouldInitialize() {
        BodyMass bm = new BodyMass(SAMPLE_MASS, SAMPLE_HEIGHT);

        assertThat(bm.getWeight(), equalTo(SAMPLE_MASS));
        assertThat(bm.getHeight(), equalTo(SAMPLE_HEIGHT));
    }

    @Test
    public void bodyMassIndex() {
        BodyMass bm = new BodyMass(SAMPLE_MASS, SAMPLE_HEIGHT);

        double expectedBmi = SAMPLE_MASS / (SAMPLE_HEIGHT * SAMPLE_HEIGHT);
        assertThat(bm.bodyMassIndex(), equalTo(expectedBmi));
    }

    @Test
    public void body() {
        BodyMass bm = new BodyMass(SAMPLE_MASS, SAMPLE_HEIGHT);
        BodyMass bmUnder = new BodyMass(SAMPLE_MASS_UNDER, SAMPLE_HEIGHT_UNDER);
        BodyMass bmOver = new BodyMass(SAMPLE_MASS_OVER, SAMPLE_HEIGHT_OVER);

        assertThat(bm.body(), equalTo(BmiCategory.NORMAL));
        assertThat(bmUnder.body(), equalTo(BmiCategory.UNDERWEIGHT));
        assertThat(bmOver.body(), equalTo(BmiCategory.OVERWEIGHT));
    }

    @Test
    public void isThinnerThan() {
        BodyMass bm = new BodyMass(SAMPLE_MASS, SAMPLE_HEIGHT);
        BodyMass bmUnder = new BodyMass(SAMPLE_MASS_UNDER, SAMPLE_HEIGHT_UNDER);

        assertThat(bm.isThinnerThan(bmUnder), is(false));
        assertThat(bmUnder.isThinnerThan(bm), is(true));
        assertThat(bm.isThinnerThan(bm), is(false));
    }
}