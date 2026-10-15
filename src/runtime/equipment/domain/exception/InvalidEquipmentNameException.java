package runtime.equipment.domain.exception;

public class InvalidEquipmentNameException extends EquipmentException {
    public InvalidEquipmentNameException() {
        super("Equipment name cannot be blank");
    }
}
