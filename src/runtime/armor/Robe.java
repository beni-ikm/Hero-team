package runtime.armor;

import runtime.equipment.domain.partofequipment.*;

public class Robe extends Armor {

    public int intelligenceBonus;
    public int wisdomBonus;

    public Robe(EquipmentId id,
                PlayerId playerId,
                EquipmentTemplateId templateId,
                EquipmentType equipmentType,
                EquipmentName armorName,
                EquipmentWeight weight,
                int defence) {
        super(id, playerId, templateId, equipmentType, armorName, weight, defence);
        this.intelligenceBonus = 10;
        this.wisdomBonus = 8;
    }

    @Override
    public void showBonus() {
        System.out.println("Robe Bonus: Intelligence +" + intelligenceBonus + ", Wisdom +" + wisdomBonus);
    }


}
