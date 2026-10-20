package runtime.potions;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.partofequipment.*;

public abstract class Potion extends Equipment {

    private PotionLevel potionLevel;

    public Potion(EquipmentId id,
                  PlayerId playerId,
                  EquipmentTemplateId templateId,
                  EquipmentType equipmentType,
                  EquipmentName equipmentName,
                  PotionLevel potionLevel,
                  EquipmentWeight weight) {
        super(id, playerId, templateId, equipmentType, equipmentName, weight);
        this.potionLevel = potionLevel;
    }




}
