package Runtime.Hero.domain.exception;

public class HeroModificatorBonusOverTheLimitException extends RuntimeException {
    public HeroModificatorBonusOverTheLimitException(String message) {
        super(message);
    }
}
