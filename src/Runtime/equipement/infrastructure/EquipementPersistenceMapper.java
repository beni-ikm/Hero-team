package Runtime.equipement.infrastructure;

import Runtime.equipement.domain.Equipement;
import Runtime.equipement.domain.partofequipement.*;

public class EquipementPersistenceMapper{

    public EquipementPersistanceModel toPersistence(Equipement equipement){
        return new EquipementPersistanceModel(
                equipement.id().value(),
                equipement.playerId().value(),
                equipement.templateId().value(),
                equipement.equipementType().value(),
                equipement.name().value(),
                equipement.weight().value()
        );
    }

    public Equipement toDomain(EquipementPersistanceModel model){
        return new Equipement(
                new EquipementId(model.id()),
                new PlayerId(model.playerId()),
                new EquipementTemplateId(model.templateId()),
                new EquipementType(model.equipementType()),
                new EquipementName(model.name()),
                new EquipementWeight(model.weight()));
    }

}
