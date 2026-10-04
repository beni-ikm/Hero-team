package Runtime.hero.domain.exception;

public class InvalidPlayerException extends RuntimeException {
    public InvalidPlayerException() {
        super("Player id cannot be blank.");
    }
}
