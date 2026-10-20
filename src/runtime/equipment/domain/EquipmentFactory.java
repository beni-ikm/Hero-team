package runtime.equipment.domain;

import runtime.equipment.domain.partofequipment.*;

public class EquipmentFactory {

    public Equipment create(
            String playerId,
            String templateId,
            String equipmentType,
            String name,
            int weight) {
        return new Equipment(
                EquipmentId.generate(),
                new PlayerId(playerId),
                new EquipmentTemplateId(templateId),
                EquipmentType.of(equipmentType),
                new EquipmentName(name),
                new EquipmentWeight(weight)
        );
    }
}
