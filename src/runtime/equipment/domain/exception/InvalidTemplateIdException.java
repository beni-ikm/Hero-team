package runtime.equipment.domain.exception;

public class InvalidTemplateIdException extends EquipmentException {
    public InvalidTemplateIdException() {
        super("Template id cannot be empty");
    }
}
