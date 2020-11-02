package pets;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VetTest {

    @Test
    public void testAddDifferent() {
        Vet vet = new Vet();

        vet.add(new Pet("Blöki", LocalDate.of(2017, 10, 23), Gender.MALE, "000145"));
        vet.add(new Pet("Szerénke", LocalDate.of(2012, 4, 9), Gender.FEMALE, "000129"));

        assertEquals(2, vet.getPets().size());
    }

    @Test
    public void testAddSame() {
        Vet vet = new Vet();

        vet.add(new Pet("Blöki", LocalDate.of(2017, 10, 23), Gender.MALE, "000145"));
        vet.add(new Pet("Szerénke", LocalDate.of(2012, 4, 9), Gender.FEMALE, "000145"));

        assertEquals(1, vet.getPets().size());
    }
}
