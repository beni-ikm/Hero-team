package Runtime.equipementpackage.domain.exception;

public class InvalidEquipementWeightException extends EquipementException {
    public InvalidEquipementWeightException(int minimun) {
        super("Equipement weight must be at least " + minimun + ".");
    }
}
