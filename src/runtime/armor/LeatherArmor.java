package runtime.armor;

import runtime.equipment.domain.partofequipment.*;

public class LeatherArmor extends Armor {

    public int dexterityBonus;
    public int charismaBonus;

    public LeatherArmor(EquipmentId id,
                        PlayerId playerId,
                        EquipmentTemplateId templateId,
                        EquipmentType equipmentType,
                        EquipmentName armorName,
                        EquipmentWeight weight,
                        int defence) {
        super(id, playerId, templateId, equipmentType, armorName, weight, defence);
        this.charismaBonus = 8;
        this.dexterityBonus = 6;
    }

    @Override
    public void showBonus() {
        System.out.println("Leather Armor Bonus: Dexterity +" + dexterityBonus + ", Charisma +" + charismaBonus);
    }

}
