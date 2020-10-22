package introexception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 20);
        assertThat(trainer.getName(), equalTo("John Doe"));
    }

    @Test
    public void testInvalidAge() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid age: 13");
        new Trainer("John Doe", 13);
    }
}
