package exceptionmulticatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrainerParserTest {

    @Test
    public void testValid() {
        Trainer trainer = new TrainerParser().parse("John Doe;30");
        assertEquals("John Doe", trainer.getName());
        assertEquals(30, trainer.getAge());
    }

    @Test
    public void testNull() {
        Exception e = assertThrows(ParserException.class, () -> {
            new TrainerParser().parse(null);
        });
        assertEquals(NullPointerException.class, e.getCause().getClass());
    }

    @Test
    public void testInvalid() {
        Exception e = assertThrows(ParserException.class, () -> {
            new TrainerParser().parse("");
        });
        assertEquals(ArrayIndexOutOfBoundsException.class, e.getCause().getClass());
    }

    @Test
    public void testInvalidNumber() {
        Exception e = assertThrows(ParserException.class, () -> {
            new TrainerParser().parse("John Doe;abc");
        });
        assertEquals(NumberFormatException.class, e.getCause().getClass());
    }
}
