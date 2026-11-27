package runtime.player.domain.exception;

public class TakenPlayerPseudonymException extends PlayerException {
    public TakenPlayerPseudonymException() {

        super("This pseudonym is already taken by another player.");
    }
}
