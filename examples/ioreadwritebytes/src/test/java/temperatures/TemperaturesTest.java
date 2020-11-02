package temperatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TemperaturesTest {

    public byte[] data = new byte[365];

    @BeforeEach
    public void initData() {
        Random random = new Random(5);
        random.nextBytes(data);
    }

    @Test
    public void testGetYearAverage() {
        Temperatures temperatures = new Temperatures(data);

        double average = temperatures.getYearAverage();

        assertEquals(3.778, average, 0.0001);
    }

    @Test
    public void testGetMonthAverage() {
        Temperatures temperatures = new Temperatures(data);

        double average = temperatures.getMonthAverage();

        assertEquals(10.2, average, 0.0001);
    }
}
