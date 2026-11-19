package runtime.hero.domain.exception;

public class HeroLevelOutOfBoundsException extends RuntimeException {
    public HeroLevelOutOfBoundsException() {
        super("The Hero level is out of bounds.");
    }
}
