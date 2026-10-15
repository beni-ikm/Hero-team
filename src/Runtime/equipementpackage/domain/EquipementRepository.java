package Runtime.equipementpackage.domain;

import Runtime.equipementpackage.domain.partofequipement.EquipementId;

public interface EquipementRepository {

    void save(Equipement equipement);

    Equipement fetchById(EquipementId id);

}
