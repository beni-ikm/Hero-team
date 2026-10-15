package runtime.equipementpackage.domain.exception;

import runtime.equipementpackage.domain.partofequipement.EquipementId;

public class EquipementNotFoundException extends EquipementException {
    public EquipementNotFoundException(EquipementId id) {
        super("Equipement with id " + id.value() + " not found.");
    }
}
