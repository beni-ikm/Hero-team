package runtime.account.domain;

import runtime.account.domain.exception.InvalidAccountEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record AccountEmail(String value) {

    public AccountEmail {
        if (value == null || value.isBlank() || !(emailValidator(value))) {
            throw new InvalidAccountEmailException();
        }
    }

    private boolean emailValidator(String value) {

        final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = EMAIL_PATTERN.matcher(value);

        return matcher.matches();
    }

}
