package runtime.account.domain.exception;

public class AccountPseudonymTooShortException extends RuntimeException{

    public AccountPseudonymTooShortException() {
        super("Account pseudonym is too short, it should be at least 3 characters.");
    }

}
