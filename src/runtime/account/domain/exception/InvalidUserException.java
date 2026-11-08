package runtime.account.domain.exception;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {

        super("Account user cannot be blank.");
    }
}
