package runtime.combat.bestiaire;

public abstract class BestiaireException extends RuntimeException {
    protected BestiaireException(String message) {
        super(message);
    }

    protected BestiaireException(String message, Throwable cause) {
        super(message, cause);
    }
}
