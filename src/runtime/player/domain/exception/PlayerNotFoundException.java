package runtime.player.domain.exception;

import runtime.player.domain.PlayerId;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(PlayerId id) {
        super("Player with id " + id.value() + " not found.");
    }
}
