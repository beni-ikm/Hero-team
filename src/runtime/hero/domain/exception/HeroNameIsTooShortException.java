package runtime.hero.domain.exception;

public class HeroNameIsTooShortException extends RuntimeException {
    public HeroNameIsTooShortException() {
        super("The Hero name is too short, it should be at least 3 letters");
    }
}
