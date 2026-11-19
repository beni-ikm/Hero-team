package runtime.player.domain;

import runtime.player.domain.exception.InvalidPlayerEmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record PlayerEmail(String value) {

    public PlayerEmail {
        if (value == null || value.isBlank() || !(emailValidator(value))) {
            throw new InvalidPlayerEmailException();
        }
    }

    private boolean emailValidator(String value) {

        final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = EMAIL_PATTERN.matcher(value);

        return matcher.matches();
    }

}
