package bank2;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {
    public InvalidAmountBankOperationException() {
    }

    public InvalidAmountBankOperationException(String message) {
        super(message);
    }
}
