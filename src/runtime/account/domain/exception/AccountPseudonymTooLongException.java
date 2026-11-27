package runtime.account.domain.exception;

public class AccountPseudonymTooLongException extends RuntimeException {

    public AccountPseudonymTooLongException() {
        super("Account pseudonym is too long, it should be max 20 characters.");
    }
}
