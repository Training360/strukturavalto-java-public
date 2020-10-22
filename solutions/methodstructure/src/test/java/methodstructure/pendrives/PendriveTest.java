package methodstructure.pendrives;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PendriveTest {

    @Test
    public void constructorShouldInitialize() {
        Pendrive pendrive = new Pendrive("Datatraveller", 32, 5000);

        assertThat(pendrive.getName(), equalTo("Datatraveller"));
        assertThat(pendrive.getCapacity(), equalTo(32));
        assertThat(pendrive.getPrice(), equalTo(5000));
    }

    @Test
    public void risePrice() {
        Pendrive pendrive = new Pendrive("Datatraveller", 32, 5000);

        pendrive.risePrice(10);
        assertThat(pendrive.getPrice(), equalTo(5500));
    }

    @Test
    public void comparePricePerCapacity() {
        Pendrive pendrive = new Pendrive("Datatraveller", 32, 5000);
        Pendrive pendrive2 = new Pendrive("Kingston", 64, 7000);
        Pendrive pendrive3 = new Pendrive("Datatraveller", 32, 5001);

        assertThat(pendrive.comparePricePerCapacity(pendrive2), equalTo(1));
        assertThat(pendrive2.comparePricePerCapacity(pendrive), equalTo(-1));
        assertThat(pendrive.comparePricePerCapacity(pendrive), equalTo(0));
        assertThat(pendrive.comparePricePerCapacity(pendrive3), equalTo(-1));
    }

    @Test
    public void cheaperThan() {
        Pendrive pendrive = new Pendrive("Datatraveller", 32, 5000);
        Pendrive pendrive2 = new Pendrive("Kingston", 64, 7000);

        assertThat(pendrive.cheaperThan(pendrive2), is(true));
        assertThat(pendrive2.cheaperThan(pendrive), is(false));
    }
}