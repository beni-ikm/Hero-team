package runtime.equipment.domain.exception;

import runtime.equipment.domain.partofequipment.EquipmentId;

public class EquipmentNotFoundException extends EquipmentException {
    public EquipmentNotFoundException(EquipmentId id) {
        super("Equipment with id " + id.value() + " not found.");
    }
}
