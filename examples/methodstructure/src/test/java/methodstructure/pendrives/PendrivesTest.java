package methodstructure.pendrives;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PendrivesTest {

    private static final List<Pendrive> PENDRIVE_LIST = Arrays.asList(
            new Pendrive("p1", 64, 3500),
            new Pendrive("p2", 32, 2000),
            new Pendrive("p3", 64, 3000),
            new Pendrive("p4", 32, 2500)
    );

    @Test
    public void best() {
        Pendrives pendrives = new Pendrives();

        assertThat(pendrives.best(PENDRIVE_LIST), equalTo(PENDRIVE_LIST.get(2)));
    }

    @Test
    public void cheapest() {
        Pendrives pendrives = new Pendrives();

        assertThat(pendrives.cheapest(PENDRIVE_LIST), equalTo(PENDRIVE_LIST.get(1)));
    }

    @Test
    public void risePriceWhereCapacity() {
        Pendrives pendrives = new Pendrives();

        int[] expected = {3500, 2200, 3000, 2750};
        pendrives.risePriceWhereCapacity(PENDRIVE_LIST, 10, 32);
        for (int j = 0; j < PENDRIVE_LIST.size(); j++) {
            assertThat(PENDRIVE_LIST.get(j).getPrice(), equalTo(expected[j]));
        }
    }
}