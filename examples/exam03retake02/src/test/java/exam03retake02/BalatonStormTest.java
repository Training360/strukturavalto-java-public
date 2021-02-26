package exam03retake02;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalatonStormTest {

    @Test
    void testGetStationsInStorm() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(BalatonStormTest.class.getResourceAsStream("storm.json")))) {
            assertEquals(List.of("Ábrahámhegy", "Balatonfüred", "Balatonszárszó"), new BalatonStorm().getStationsInStorm(reader));
        }
    }
}
