package Runtime.equipement.domain.partofequipement;

import Runtime.equipement.domain.exception.InvalidEquipementTypeException;

public record EquipementType(String value) {

    public EquipementType {
        if (value == null || value.isBlank()) {
            throw new InvalidEquipementTypeException();
        }
    }

    public static EquipementType of(String value){
        return new EquipementType(value.trim().toUpperCase());
    }

}
