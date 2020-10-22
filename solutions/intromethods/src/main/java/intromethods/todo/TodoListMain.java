package intromethods.todo;

import java.util.Arrays;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.addTodo("Pay bills");
        todoList.addTodo("Meet George");
        todoList.addTodo("Buy eggs");
        todoList.addTodo("Read a book");
        todoList.addTodo("Organize office");

        System.out.println(todoList);

        todoList.finishTodos("Pay bills");

        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("Buy eggs", "Read a book"));

        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());

    }
}
