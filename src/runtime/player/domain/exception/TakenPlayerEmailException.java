package runtime.player.domain.exception;

public class TakenPlayerEmailException extends PlayerException {
    public TakenPlayerEmailException() {

        super("Player email already used in another account");
    }
}
