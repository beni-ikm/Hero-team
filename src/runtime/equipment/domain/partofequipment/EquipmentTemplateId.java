package runtime.equipment.domain.partofequipment;


import runtime.equipment.domain.exception.InvalidTemplateIdException;

public record EquipmentTemplateId(String value) {

public EquipmentTemplateId {

        if (value == null || value.isBlank()){
            throw new InvalidTemplateIdException();
        }
    }

}




