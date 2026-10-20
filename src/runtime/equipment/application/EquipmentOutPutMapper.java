package runtime.equipment.application;

import runtime.equipment.domain.Equipment;

public class EquipmentOutPutMapper {

    public EquipmentOutPut toOutput(Equipment equipment){
        return new EquipmentOutPut(
                equipment.id().value(),
                equipment.playerId().value(),
                equipment.templateId().value(),
                equipment.equipmentType().value(),
                equipment.name().value(),
                equipment.weight().value());
    }
}

