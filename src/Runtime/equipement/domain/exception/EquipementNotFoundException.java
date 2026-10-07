package Runtime.equipement.domain.exception;

import Runtime.equipement.domain.partofequipement.EquipementId;

public class EquipementNotFoundException extends EquipementException {
    public EquipementNotFoundException(EquipementId id) {
        super("Equipement with id " + id.value() + " not found.");
    }
}
