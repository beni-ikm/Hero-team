package Runtime.equipement.domain.partofequipement;

import Runtime.equipement.domain.exception.InvalidEquipementWeightException;

public record EquipementWeight(int value) {

    public static final int MINIMUM = 1;

    public EquipementWeight {
        if (value < MINIMUM){
            throw new InvalidEquipementWeightException(MINIMUM);
        }
    }

}
