package statemachine.typewriter;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TypeWriterStateTest {

    @Test
    public void testNext() {

        assertThat(TypeWriterState.LOWERCASE.next(), is(TypeWriterState.UPPERCASE));
        assertThat(TypeWriterState.UPPERCASE.next(), is(TypeWriterState.LOWERCASE));
    }
}
