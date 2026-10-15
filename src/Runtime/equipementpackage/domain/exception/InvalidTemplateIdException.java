package Runtime.equipementpackage.domain.exception;

public class InvalidTemplateIdException extends EquipementException {
    public InvalidTemplateIdException() {
        super("Template id cannot be empty");
    }
}
