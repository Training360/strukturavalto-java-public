package exam03;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistogramTest {

    @Test
    void createHistogram() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(HistogramTest.class.getResourceAsStream("histogram.txt")))) {
            String result = new Histogram().createHistogram(reader);
//            System.out.println(result);
            assertEquals("***\n" +
                    "****\n" +
                    "**\n" +
                    "*\n", result);
        }
    }
}
