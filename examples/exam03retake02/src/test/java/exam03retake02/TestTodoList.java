package exam03retake02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTodoList {

    TodoList todoList = new TodoList();

    @BeforeEach
    void init() {
        todoList.addTodo(new Todo("Bevásárlás", 1));
        todoList.addTodo(new Todo("Foci", 5));
        todoList.addTodo(new Todo("Szolgáltató", 2));
        todoList.addTodo(new Todo("Számlák", 3));
        todoList.addTodo(new Todo("Vizsga", 1));

        todoList.getTodos().get(2).complete();
        todoList.getTodos().get(4).complete();
    }

    @Test
    void getNumberOfItemsLeft() {
        assertEquals(3, todoList.getNumberOfItemsLeft());
    }

    @Test
    void getMostImportantTodosText() {
        assertEquals(List.of("Bevásárlás", "Vizsga"), todoList.getMostImportantTodosText());
    }

    @Test
    void getMostImportantTodosTextAnother() {
        TodoList anotherTodoList = new TodoList();
        anotherTodoList.addTodo(new Todo("Bevásárlás", 3));
        anotherTodoList.addTodo(new Todo("Foci", 5));
        anotherTodoList.addTodo(new Todo("Szolgáltató", 2));

        assertEquals(List.of("Szolgáltató"), anotherTodoList.getMostImportantTodosText());
    }

    @Test
    void deleteCompleted() {
        todoList.deleteCompleted();

        assertEquals(3, todoList.getTodos().size());
    }
}
