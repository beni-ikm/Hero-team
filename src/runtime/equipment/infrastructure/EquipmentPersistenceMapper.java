package runtime.equipment.infrastructure;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.partofequipment.*;

public class EquipmentPersistenceMapper {

    public EquipmentPersistenceModel toPersistence(Equipment equipment){
        return new EquipmentPersistenceModel(
                equipment.id().value(),
                equipment.playerId().value(),
                equipment.templateId().value(),
                equipment.equipmentType().value(),
                equipment.name().value(),
                equipment.weight().value()
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
