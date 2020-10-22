package staticattrmeth;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static staticattrmeth.Trainer.getNumberOfTrainers;

public class TrainerTest {

    @Test
    public void testCreate() {
        assertThat(getNumberOfTrainers(), equalTo(0));
        Trainer t = new Trainer("John Doe");
        assertThat(getNumberOfTrainers(), equalTo(1));
        Trainer t2 = new Trainer("Jane Doe");
        assertThat(getNumberOfTrainers(), equalTo(2));
    }

}
