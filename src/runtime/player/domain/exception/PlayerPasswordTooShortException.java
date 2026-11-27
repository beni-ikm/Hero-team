package runtime.player.domain.exception;

public class PlayerPasswordTooShortException extends PlayerException {
    public PlayerPasswordTooShortException() {

        super("Player password is too short");
    }
}
