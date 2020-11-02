package statemachine.typewriter;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeWriterStateTest {

    @Test
    public void testNext() {

        assertEquals(TypeWriterState.UPPERCASE, TypeWriterState.LOWERCASE.next());
        assertEquals(TypeWriterState.LOWERCASE, TypeWriterState.UPPERCASE.next());
    }
}
