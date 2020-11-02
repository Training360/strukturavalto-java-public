package controladvanced.duplicates;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DuplicatesTest {

    @Test
    public void findDuplicates() {
        assertEquals(Arrays.asList(), new Duplicates().find(Arrays.asList()));
        assertEquals(Arrays.asList(), new Duplicates().find(Arrays.asList(1, 2, 3)));
        assertEquals(Arrays.asList(2), new Duplicates().find(Arrays.asList(1, 2, 2, 3)));
        assertEquals(Arrays.asList(2, 3), new Duplicates().find(Arrays.asList(1, 2, 2, 3, 3, 4)));
        assertEquals(Arrays.asList(3, 3), new Duplicates().find(Arrays.asList(1, 2, 3, 3, 3, 4)));
        assertEquals(Arrays.asList(2, 3, 3), new Duplicates().find(Arrays.asList(1, 2, 2, 3, 3, 3, 4)));

    }
}
