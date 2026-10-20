package runtime.equipment.domain.partofequipment;

import runtime.equipment.domain.exception.InvalidEquipmentTypeException;

public record EquipmentType(String value) {

    public EquipmentType {
        if (value == null || value.isBlank()) {
            throw new InvalidEquipmentTypeException();
        }
    }

    public static EquipmentType of(String value){
        return new EquipmentType(value.trim().toUpperCase());
    }

}
