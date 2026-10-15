package runtime.equipementpackage.domain;

import runtime.equipementpackage.domain.partofequipement.EquipementId;

public interface EquipementRepository {

    void save(Equipement equipement);

    Equipement fetchById(EquipementId id);

}
