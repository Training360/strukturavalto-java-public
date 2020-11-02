package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerBuilderTest {

    @Test
    public void build() {
        Trainer trainer = new TrainerBuilder()
                .withName("John Doe")
                .withAge(30)
                .build();

        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }
}
