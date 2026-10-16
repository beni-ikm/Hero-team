package runtime.armor;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.partofequipment.*;

public abstract class Armor extends Equipment {

    private int defence;

    public Armor(EquipmentId id,
                 PlayerId playerId,
                 EquipmentTemplateId templateId,
                 EquipmentType equipmentType,
                 EquipmentName name,
                 EquipmentWeight weight,
                 int defence){
        super(id, playerId, templateId, equipmentType, name, weight);
        this.defence = defence;
    }

    public void showBonus() {
        System.out.println("Armor Bonus: Defence +" + defence);
    }

}
