package runtime.equipementpackage.domain.exception;

public class InvalidPlayerException extends EquipementException {
    public InvalidPlayerException() {
        super("Player id cannot be blank");
    }
}
