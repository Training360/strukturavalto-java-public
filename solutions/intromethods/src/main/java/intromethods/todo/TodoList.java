package intromethods.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        Todo todo = new Todo(caption);
        todos.add(todo);
    }

    public void finishTodos(String caption) {
        for (Todo todo: todos) {
            if (todo.getCaption().equals(caption)) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String todoToFinish: todosToFinish) {
            finishTodos(todoToFinish);
        }
    }

    public List<String> todosToFinish() {
        List<String> todosToFinish = new ArrayList<>();
        for (Todo todo: todos) {
            if (!todo.isFinished()) {
                todosToFinish.add(todo.getCaption());
            }
        }
        return todosToFinish;
    }

    public int numberOfFinishedTodos() {
        int sum = 0;
        for (Todo todo: todos) {
            if (todo.isFinished()) {
                sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return todos.toString();
    }
}
