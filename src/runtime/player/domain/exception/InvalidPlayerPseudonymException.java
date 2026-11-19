package runtime.player.domain.exception;

public class InvalidPlayerPseudonymException extends RuntimeException {

    public InvalidPlayerPseudonymException() {
        super("Player pseudonym cannot be blank.");
    }

}
