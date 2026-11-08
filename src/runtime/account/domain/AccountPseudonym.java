package runtime.account.domain;

import runtime.account.domain.exception.AccountPseudonymTooLongException;
import runtime.account.domain.exception.AccountPseudonymTooShortException;
import runtime.account.domain.exception.InvalidAccountPseudonymException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record AccountPseudonym(String value) {

    public AccountPseudonym {
        if (value == null || value.isBlank() || !(pseudonymPatern(value))) {
            throw new InvalidAccountPseudonymException();
        }
        if (value.length() < 3) {
            throw new AccountPseudonymTooShortException();
        }
        if (value.length() > 20) {
            throw new AccountPseudonymTooLongException();
        }
    }

    public boolean pseudonymPatern(String value) {

        final String REGEX = "^[a-zA-Z0-9_]+$";
        final Pattern PATTERN = Pattern.compile(REGEX);

        Matcher matcher = PATTERN.matcher(value);

        return matcher.matches();
    }

}
