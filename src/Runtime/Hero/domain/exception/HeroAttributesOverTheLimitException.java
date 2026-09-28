package Runtime.Hero.domain.exception;

public class HeroAttributesOverTheLimitException extends RuntimeException {
    public HeroAttributesOverTheLimitException(String message) {
        super(message);
    }
}
