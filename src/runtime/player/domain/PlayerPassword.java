package runtime.player.domain;

import runtime.player.domain.exception.InvalidPlayerPasswordException;

public record PlayerPassword(String value) {

    public PlayerPassword {
        if (value == null || value.isBlank() || value.length() < 8){
            throw new InvalidPlayerPasswordException();
        }
    }

}
