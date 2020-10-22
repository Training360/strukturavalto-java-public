package stringbasic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void setType() {
        Trainer trainer = new Trainer("John Doe", Trainer.TrainerType.FULL_TIME);
        int h = trainer.hours();
        assertThat(h, equalTo(8));
    }
}
