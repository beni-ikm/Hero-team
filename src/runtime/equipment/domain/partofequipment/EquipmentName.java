package runtime.equipment.domain.partofequipment;

import runtime.equipment.domain.exception.InvalidEquipmentNameException;

public record EquipmentName(String value) {

    public EquipmentName {
        if (value == null || value.isBlank()){
            throw new InvalidEquipmentNameException();
        }
    }

}
