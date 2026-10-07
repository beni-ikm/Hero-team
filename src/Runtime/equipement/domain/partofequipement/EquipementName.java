package Runtime.equipement.domain.partofequipement;

import Runtime.equipement.domain.exception.InvalidEquipementNameExeception;

public record EquipementName(String value) {

    public EquipementName {
        if (value == null || value.isBlank()){
            throw new InvalidEquipementNameExeception();
        }
    }

}
