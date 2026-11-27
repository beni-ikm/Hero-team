package runtime.player.domain.exception;

public class PlayerPseudonymTooShortException extends PlayerException{

    public PlayerPseudonymTooShortException() {
        super("Player pseudonym is too short, it should be at least 3 characters.");
    }

}
