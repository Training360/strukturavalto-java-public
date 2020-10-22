package bank2;

public class InvalidBankOperationException extends RuntimeException {
    public InvalidBankOperationException() {
    }

    public InvalidBankOperationException(String message) {
        super(message);
    }
}
