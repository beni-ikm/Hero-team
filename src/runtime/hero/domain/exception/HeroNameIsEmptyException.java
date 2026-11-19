package runtime.hero.domain.exception;

public class HeroNameIsEmptyException extends RuntimeException {
    public HeroNameIsEmptyException() {
        super("Hero name is empty");
    }
}
