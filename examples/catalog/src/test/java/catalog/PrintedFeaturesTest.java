package catalog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PrintedFeaturesTest {

    @Test
    public void testCreate() {
        PrintedFeatures audioFeatures = new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling", "Someoneelse"));
        assertEquals(2, audioFeatures.getContributors().size());
        assertEquals("Someoneelse", audioFeatures.getContributors().get(1));

        assertEquals("Harry Potter", audioFeatures.getTitle());
        assertEquals(600, audioFeatures.getNumberOfPages());
    }

    @Test
    public void missingTitle() {
        Exception actualException = assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("", 600, Arrays.asList("J.K. Rowling", "Someoneelse"));
        });
        assertEquals("Empty title", actualException.getMessage());
    }

    @Test
    public void invalidNumberOfPages() {

        assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("Harry Potter", -1, Arrays.asList("J.K. Rowling", "Someoneelse"));
        });

    }

    @Test
    public void noPerformer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PrintedFeatures("Harry Potter", 600, null);
        });

    }
}
