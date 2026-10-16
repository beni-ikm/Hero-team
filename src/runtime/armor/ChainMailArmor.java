package runtime.armor;

import runtime.equipment.domain.partofequipment.*;

public class ChainMailArmor extends Armor{

    public int strengthBonus;
    public int constitutionBonus;

    public ChainMailArmor(EquipmentId id,
                          PlayerId playerId,
                          EquipmentTemplateId templateId,
                          EquipmentType equipmentType,
                          EquipmentName armorName,
                          EquipmentWeight weight,
                          int defence) {
        super(id, playerId, templateId, equipmentType, armorName, weight, defence);
        this.constitutionBonus = 5;
        this.strengthBonus = 4;
    }

    @Override
    public void showBonus() {
        System.out.println("Chain Mail Armor Bonus: Strength +" + strengthBonus + ", Constitution +" + constitutionBonus);
    }


}
