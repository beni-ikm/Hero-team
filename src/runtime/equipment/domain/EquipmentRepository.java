package runtime.equipment.domain;

import runtime.equipment.domain.partofequipment.EquipmentId;

public interface EquipmentRepository {

    void save(Equipment equipment);

    Equipment fetchById(EquipmentId id);

}
