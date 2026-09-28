package Runtime.Hero.domain.exception;

public class HeroNameInvalidException extends RuntimeException {
    public HeroNameInvalidException(String name) {
        super("Runtime.Hero name "+ name + " is not valid");
    }
}
