package runtime.player.domain;

import runtime.player.domain.exception.InvalidPlayerPasswordException;

import java.util.Objects;

public record PlayerPassword(String value) {

    static final String EMPTY_PASSWORD = "passwordHasher must not be null";

    public PlayerPassword {
        if (invalidPassword(value)){
            throw new InvalidPlayerPasswordException();
        }
    }

    public static PlayerPassword fromRawPassword(String rawPassword, PasswordHasher passwordHasher) {

        Objects.requireNonNull(passwordHasher, EMPTY_PASSWORD);
        if (invalidPassword(rawPassword)){
            throw new InvalidPlayerPasswordException();
        }
        return new PlayerPassword(passwordHasher.hash(rawPassword));
    }

    public boolean matches(String rawPassword, PasswordHasher passwordHasher) {
        Objects.requireNonNull(passwordHasher, EMPTY_PASSWORD);
        if (rawPassword == null) {
            return false;
        }
        return passwordHasher.matches(rawPassword, this.value);
    }

    public static boolean invalidPassword(String password) {
        if (password == null || password.isBlank() || password.length() < 8) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PlayerPassword[***]";
    }

}
