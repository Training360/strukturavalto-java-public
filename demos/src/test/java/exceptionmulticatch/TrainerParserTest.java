package exceptionmulticatch;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class TrainerParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNull() {
        expectedException.expect(ParserException.class);
        expectedException.expectCause(instanceOf(NullPointerException.class));
        new TrainerParser().parse(null);
    }

    @Test
    public void testInvalid() {
        expectedException.expect(ParserException.class);
        expectedException.expectCause(instanceOf(IndexOutOfBoundsException.class));
        new TrainerParser().parse("");
    }

    @Test
    public void testInvalidNumber() {
        expectedException.expect(ParserException.class);
        expectedException.expectCause(instanceOf(NumberFormatException.class));
        new TrainerParser().parse("John Doe;abc");
    }

    @Test
    public void testValid() {
        Trainer trainer = new TrainerParser().parse("John Doe;30");
        assertThat(trainer.getName(), equalTo("John Doe"));
        assertThat(trainer.getAge(), equalTo(30));
    }
}
