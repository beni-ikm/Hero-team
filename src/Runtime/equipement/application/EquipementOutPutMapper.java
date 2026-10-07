package Runtime.equipement.application;

import Runtime.equipement.domain.Equipement;

public class EquipementOutPutMapper {

    public EquipementOutPut toOutput(Equipement equipement){
        return new EquipementOutPut(
                equipement.id().value(),
                equipement.playerId().value(),
                equipement.templateId().value(),
                equipement.equipementType().value(),
                equipement.name().value(),
                equipement.weight().value());
    }
}

