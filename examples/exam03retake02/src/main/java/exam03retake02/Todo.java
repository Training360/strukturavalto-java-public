package exam03retake02;

public class Todo {

    private String text;

    private int priority;

    private State state = State.NON_COMPLETED;

    public Todo(String text, int priority) {
        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("Invalid priority: " + priority);
        }
        this.text = text;
        this.priority = priority;
    }

    public String getText() {
        return text;
    }

    public int getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    public void complete() {
        state = State.COMPLETED;
    }
}
