package runtime.equipementpackage.domain.exception;

public class InvalidEquipementNameExeception extends EquipementException {
    public InvalidEquipementNameExeception() {
        super("Equipement name cannot be blank");
    }
}
