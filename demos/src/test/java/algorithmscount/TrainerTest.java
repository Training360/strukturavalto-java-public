package algorithmscount;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }

}
