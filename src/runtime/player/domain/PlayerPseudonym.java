package runtime.player.domain;

import runtime.player.domain.exception.PlayerPseudonymTooLongException;
import runtime.player.domain.exception.PlayerPseudonymTooShortException;
import runtime.player.domain.exception.InvalidPlayerPseudonymException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record PlayerPseudonym(String value) {

    public PlayerPseudonym {
        if (value == null || value.isBlank() || !(pseudonymPatern(value))) {
            throw new InvalidPlayerPseudonymException();
        }
        if (value.length() < 3) {
            throw new PlayerPseudonymTooShortException();
        }
        if (value.length() > 20) {
            throw new PlayerPseudonymTooLongException();
        }
    }

    public boolean pseudonymPatern(String value) {

        final String REGEX = "^[a-zA-Z0-9_]+$";
        final Pattern PATTERN = Pattern.compile(REGEX);

        Matcher matcher = PATTERN.matcher(value);

        return matcher.matches();
    }

}
