package runtime.equipment.domain.exception;

public class InvalidPlayerException extends EquipmentException {
    public InvalidPlayerException() {
        super("Player id cannot be blank");
    }
}
