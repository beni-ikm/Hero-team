package Runtime.equipement.domain;

import Runtime.equipement.domain.partofequipement.EquipementId;

public interface EquipementRepository {

    void save(Equipement equipement);

    Equipement fetchById(EquipementId id);

}
