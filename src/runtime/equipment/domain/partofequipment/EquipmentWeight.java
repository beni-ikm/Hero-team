package runtime.equipment.domain.partofequipment;

import runtime.equipment.domain.exception.InvalidEquipmentWeightException;

public record EquipmentWeight(int value) {

    public static final int MINIMUM = 1;

    public EquipmentWeight {
        if (value < MINIMUM){
            throw new InvalidEquipmentWeightException(MINIMUM);
        }
    }

}
