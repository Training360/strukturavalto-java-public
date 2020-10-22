package bank2;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    public LowBalanceBankOperationException() {
    }

    public LowBalanceBankOperationException(String message) {
        super(message);
    }

}
