package runtime.equipment.infrastructure;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.partofequipment.*;

public class EquipmentPersistenceMapper {

    public EquipmentPersistenceModel toPersistence(Equipment equipement){
        return new EquipmentPersistenceModel(
                equipement.id().value(),
                equipement.playerId().value(),
                equipement.templateId().value(),
                equipement.equipementType().value(),
                equipement.name().value(),
                equipement.weight().value()
        );
    }

    public Equipment toDomain(EquipmentPersistenceModel model){
        return new Equipment(
                new EquipmentId(model.id()),
                new PlayerId(model.playerId()),
                new EquipmentTemplateId(model.templateId()),
                new EquipmentType(model.equipmentType()),
                new EquipmentName(model.name()),
                new EquipmentWeight(model.weight()));
    }

}
