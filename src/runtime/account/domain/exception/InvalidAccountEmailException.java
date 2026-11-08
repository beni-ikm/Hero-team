package runtime.account.domain.exception;

public class InvalidAccountEmailException extends RuntimeException {

    public InvalidAccountEmailException() {

        super("Account email cannot be blank.");

    }
}
