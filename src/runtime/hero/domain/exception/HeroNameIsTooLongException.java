package runtime.hero.domain.exception;

public class HeroNameIsTooLongException extends RuntimeException {
    public HeroNameIsTooLongException() {
        super("The Hero name is too long, it should be maximum 20 letters");
    }
}
