package exceptionclass;

public class InvalidAgeException extends RuntimeException {

    private int parameterAge;

    private int minAge;

    public InvalidAgeException(String message, int parameterAge, int minAge) {
        super(message);
        this.parameterAge = parameterAge;
        this.minAge = minAge;
    }

    public int getParameterAge() {
        return parameterAge;
    }

    public int getMinAge() {
        return minAge;
    }
}
