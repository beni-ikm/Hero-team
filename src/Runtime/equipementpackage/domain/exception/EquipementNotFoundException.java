package Runtime.equipementpackage.domain.exception;

import Runtime.equipementpackage.domain.partofequipement.EquipementId;

public class EquipementNotFoundException extends EquipementException {
    public EquipementNotFoundException(EquipementId id) {
        super("Equipement with id " + id.value() + " not found.");
    }
}
