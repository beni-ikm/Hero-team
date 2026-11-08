package runtime.account.domain.exception;

import runtime.account.domain.AccountId;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(AccountId id) {
        super("Account with id " + id.value() + " not found.");
    }
}
