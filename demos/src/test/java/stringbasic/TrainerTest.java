package stringbasic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

    @Test
    public void setType() {
        Trainer trainer = new Trainer("John Doe", Trainer.TrainerType.FULL_TIME);
        int h = trainer.hours();
        assertEquals(8, h);
    }
}
