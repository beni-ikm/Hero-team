package Runtime.equipementpackage.domain.exception;

public class InvalidEquipementTypeException extends EquipementException {
    public InvalidEquipementTypeException() {
        super("Equipement type cannot be blank");
    }
}
