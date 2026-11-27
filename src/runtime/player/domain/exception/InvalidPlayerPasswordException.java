package runtime.player.domain.exception;

public class InvalidPlayerPasswordException extends PlayerException {
    public InvalidPlayerPasswordException() {
        super("Player password cannot be blank.");
    }
}
