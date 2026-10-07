package Runtime.equipement.domain.partofequipement;


import Runtime.equipement.domain.exception.InvalidTemplateIdException;

public record EquipementTemplateId(String value) {

public EquipementTemplateId{

        if (value == null || value.isBlank()){
            throw new InvalidTemplateIdException();
        }
    }

}




