package runtime.account.domain.exception;

public class InvalidAccountPseudonymException extends RuntimeException {

    public InvalidAccountPseudonymException() {
        super("Account pseudonym cannot be blank.");
    }

}
