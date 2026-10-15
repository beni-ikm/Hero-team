package runtime.equipementpackage.domain.partofequipement;

import runtime.equipementpackage.domain.exception.InvalidEquipementNameExeception;

public record EquipementName(String value) {

    public EquipementName {
        if (value == null || value.isBlank()){
            throw new InvalidEquipementNameExeception();
        }
    }

}
