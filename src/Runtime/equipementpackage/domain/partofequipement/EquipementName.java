package Runtime.equipementpackage.domain.partofequipement;

import Runtime.equipementpackage.domain.exception.InvalidEquipementNameExeception;

public record EquipementName(String value) {

    public EquipementName {
        if (value == null || value.isBlank()){
            throw new InvalidEquipementNameExeception();
        }
    }

}
