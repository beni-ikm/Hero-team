package Runtime.Hero.domain.exception;

public class HeroAttributesUnderTheLimitException extends RuntimeException {
    public HeroAttributesUnderTheLimitException(String message) {

        super(message);
    }
}
