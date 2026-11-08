package runtime.account.domain;

import runtime.account.domain.exception.InvalidAccountPasswordException;

public record AccountPassword(String value) {

    public AccountPassword {
        if (value == null || value.isBlank() || value.length() < 8){
            throw new InvalidAccountPasswordException();
        }
    }

}
