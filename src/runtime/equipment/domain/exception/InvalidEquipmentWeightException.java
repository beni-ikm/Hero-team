package runtime.equipment.domain.exception;

public class InvalidEquipmentWeightException extends EquipmentException {
    public InvalidEquipmentWeightException(int minimum) {
        super("Equipment weight must be at least " + minimum + ".");
    }
}
