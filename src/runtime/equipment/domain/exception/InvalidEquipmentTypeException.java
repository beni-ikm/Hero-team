package runtime.equipment.domain.exception;

public class InvalidEquipmentTypeException extends EquipmentException {
    public InvalidEquipmentTypeException() {
        super("Equipment type cannot be blank");
    }
}
