package runtime.combat.bestiaire;

public class BestiaireChargementException extends RuntimeException {
    public BestiaireChargementException(String message) {
        super(message);
    }

    public BestiaireChargementException(String message, Throwable cause) {
        super(message, cause);
    }
}
