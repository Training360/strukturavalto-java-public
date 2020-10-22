package exceptionclass;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class TrainerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInvalidAge() {
        expectedException.expect(InvalidAgeException.class);
        expectedException.expectMessage("Invalid age");
        expectedException.expect(hasProperty("parameterAge", is(15)));
        expectedException.expect(hasProperty("minAge", is(18)));
        new Trainer("John Doe", 15);
    }

    @Test
    public void testCreate() {
        Trainer trainer = new Trainer("John Doe", 30);
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }
}
