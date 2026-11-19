package runtime.player.domain.exception;

public class InvalidPlayerPasswordException extends RuntimeException {
    public InvalidPlayerPasswordException() {
        super("Player password cannot be blank.");
    }
}
