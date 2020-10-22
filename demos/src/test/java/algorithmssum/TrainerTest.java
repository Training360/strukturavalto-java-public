package algorithmssum;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrainerTest {

    @Test
    public void testCreateTrainer() {
        Trainer trainer = new Trainer("Sofia",21);
        
        assertThat(trainer.getAge(),is(21));
    }

}
