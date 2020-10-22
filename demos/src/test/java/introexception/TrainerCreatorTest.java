package introexception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrainerCreatorTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        TrainerCreator trainerCreator = new TrainerCreator();
        assertThat(trainerCreator.createTrainer("John Doe", "20"), is(true));
        assertThat(trainerCreator.getTrainer().getName(), equalTo("John Doe"));
        assertThat(trainerCreator.getTrainer().getAge(), equalTo(20));
    }

    @Test
    public void testCreateInvalid() {
        expectedException.expect(IllegalStateException.class);
        expectedException.expectMessage("Could not create trainer");
        TrainerCreator trainerCreator = new TrainerCreator();
        assertThat(trainerCreator.createTrainer("John Doe", "16"), is(false));
        trainerCreator.getTrainer();
    }


}
