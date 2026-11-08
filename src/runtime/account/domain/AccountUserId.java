package runtime.account.domain;

import runtime.account.domain.exception.InvalidUserException;

public record AccountUserId(String value) {

    public AccountUserId {
        if (value == null || value.isBlank()) {
            throw new InvalidUserException();
        }
    }

}
