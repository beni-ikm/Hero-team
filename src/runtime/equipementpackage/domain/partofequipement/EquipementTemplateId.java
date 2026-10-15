package runtime.equipementpackage.domain.partofequipement;


import runtime.equipementpackage.domain.exception.InvalidTemplateIdException;

public record EquipementTemplateId(String value) {

public EquipementTemplateId{

        if (value == null || value.isBlank()){
            throw new InvalidTemplateIdException();
        }
    }

}




