package Runtime.equipementpackage.domain.partofequipement;


import Runtime.equipementpackage.domain.exception.InvalidTemplateIdException;

public record EquipementTemplateId(String value) {

public EquipementTemplateId{

        if (value == null || value.isBlank()){
            throw new InvalidTemplateIdException();
        }
    }

}




