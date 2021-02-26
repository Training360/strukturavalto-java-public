package exam03retake02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TodoTest {

    @Test
    void testCreate() {
        Todo todo = new Todo("Bevásárolni", 1);
        assertEquals("Bevásárolni", todo.getText());
        assertEquals(State.NON_COMPLETED, todo.getState());
        assertEquals(1, todo.getPriority());
    }

    @Test
    void testComplete() {
        Todo todo = new Todo("Bevásárolni", 1);
        todo.complete();
        assertEquals(State.COMPLETED, todo.getState());
    }

    @Test
    void exception() {
        assertThrows(IllegalArgumentException.class,
                () -> new Todo("Invalid", 6));
    }
}
