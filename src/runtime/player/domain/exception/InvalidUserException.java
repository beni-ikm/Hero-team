package runtime.player.domain.exception;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {

        super("Player user cannot be blank.");
    }
}
