package algorithmsmax;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainerTest {

    @Test
    public void testCreateTrainer() {
        Trainer trainer = new Trainer("Chuck", 42);

        assertThat(trainer.getAge(), is(42));
    }

}
