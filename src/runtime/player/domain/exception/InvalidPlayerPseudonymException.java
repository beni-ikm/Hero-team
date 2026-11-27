package runtime.player.domain.exception;

public class InvalidPlayerPseudonymException extends PlayerException {

    public InvalidPlayerPseudonymException() {
        super("Player pseudonym cannot be blank.");
    }

}
