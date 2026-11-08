package runtime.account.domain.exception;

public class InvalidAccountPasswordException extends RuntimeException {
    public InvalidAccountPasswordException() {
        super("Account password cannot be blank.");
    }
}
