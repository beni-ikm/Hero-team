package runtime.player.domain.exception;

public class PlayerPseudonymTooLongException extends PlayerException {

    public PlayerPseudonymTooLongException() {
        super("Player pseudonym is too long, it should be max 20 characters.");
    }
}
