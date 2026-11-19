package runtime.player.domain;

import runtime.player.domain.exception.InvalidUserException;

public record PlayerUserId(String value) {

    public PlayerUserId {
        if (value == null || value.isBlank()) {
            throw new InvalidUserException();
        }
    }

}
