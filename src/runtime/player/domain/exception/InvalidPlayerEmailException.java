package runtime.player.domain.exception;

public class InvalidPlayerEmailException extends PlayerException {

    public InvalidPlayerEmailException() {

        super("Player email cannot be blank.");

    }
}
