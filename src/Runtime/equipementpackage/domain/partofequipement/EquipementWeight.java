package Runtime.equipementpackage.domain.partofequipement;

import Runtime.equipementpackage.domain.exception.InvalidEquipementWeightException;

public record EquipementWeight(int value) {

    public static final int MINIMUM = 1;

    public EquipementWeight {
        if (value < MINIMUM){
            throw new InvalidEquipementWeightException(MINIMUM);
        }
    }

}
