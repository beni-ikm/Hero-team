package Runtime.Hero.domain.exception;

// Cette exception est pour les bonus de la clase et du travail

public class HeroModificatorBonusOverTheLimitException extends RuntimeException {
    public HeroModificatorBonusOverTheLimitException(String message) {
        super(message);
    }
}
