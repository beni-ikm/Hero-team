package runtime.player.domain.exception;

public class InvalidPlayerEmailException extends RuntimeException {

    public InvalidPlayerEmailException() {

        super("Player email cannot be blank.");

    }
}
