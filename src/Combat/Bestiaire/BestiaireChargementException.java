package Combat.Bestiaire;

public class BestiaireChargementException extends RuntimeException {
    public BestiaireChargementException(String message) {
        super(message);
    }

    public BestiaireChargementException(String message, Throwable cause) {
        super(message, cause);
    }
}
