package exam03retake02;

import java.util.*;
import java.util.stream.Collectors;

public class TodoList {

    private List<Todo> todos = new ArrayList<>();


    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public int getNumberOfItemsLeft() {
//        int sum = 0;
//        for (Todo todo: todos) {
//            if (todo.getState() == State.NON_COMPLETED) {
//                sum ++;
//            }
//        }
//        return sum;

        return (int) todos.stream()
                .filter(t -> t.getState() == State.NON_COMPLETED)
                .count();

    }

    public List<String> getMostImportantTodosText() {
//        int maxPriority = 5;
//        List<String> texts = new ArrayList<>();
//        for (Todo todo: todos) {
//            if (maxPriority > todo.getPriority()) {
//                maxPriority = todo.getPriority();
//                texts.clear();
//                texts.add(todo.getText());
//            }
//            else if (maxPriority == todo.getPriority()) {
//                texts.add(todo.getText());
//            }
//        }
//        return texts;

        OptionalInt maxPriority = todos.stream()
                .mapToInt(Todo::getPriority)
                .min();

        if (maxPriority.isEmpty()) {
            return List.of();
        }
        else {
            return todos.stream()
                    .filter(t -> t.getPriority() == maxPriority.getAsInt())
                    .map(Todo::getText)
                    .collect(Collectors.toList());
        }
    }

    public void deleteCompleted() {
//        for (Todo todo: todos) {
//            if (todo.getState() == State.COMPLETED) {
//                todos.remove(todo);
//            }
//        }

//        Iterator<Todo> it = todos.iterator();
//        while (it.hasNext()) {
//            Todo next = it.next();
//            if (next.getState() == State.COMPLETED) {
//                it.remove();
//            }
//        }

//        List<Todo> toRemove = new ArrayList<>();
//        for (Todo todo: todos) {
//            if (todo.getState() == State.COMPLETED) {
//                toRemove.add(todo);
//            }
//        }
//        todos.removeAll(toRemove);

        todos.removeIf(t -> t.getState() == State.COMPLETED);
    }
}
