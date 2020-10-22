package course;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException() {
    }

    public InvalidTimeException(String message) {
        super(message);
    }
}
