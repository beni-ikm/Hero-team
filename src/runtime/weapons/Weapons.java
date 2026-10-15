package runtime.weapons;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.partofequipment.*;

public abstract class Weapons extends Equipment implements AttackBehavior {

    private int damage;

    public Weapons(EquipmentId id,
                   PlayerId playerId,
                   EquipmentTemplateId templateId,
                   EquipmentType equipmentType,
                   EquipmentName armorName,
                   EquipmentWeight weight,
                   int damage) {
        super(id, playerId, templateId, equipmentType, armorName, weight);
        this.damage = damage;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with weapon!");
    }


}
