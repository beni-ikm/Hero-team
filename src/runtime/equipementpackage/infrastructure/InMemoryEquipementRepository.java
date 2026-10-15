package runtime.equipementpackage.infrastructure;

import runtime.equipementpackage.domain.Equipement;
import runtime.equipementpackage.domain.EquipementRepository;
import runtime.equipementpackage.domain.exception.EquipementNotFoundException;
import runtime.equipementpackage.domain.partofequipement.EquipementId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEquipementRepository implements EquipementRepository {

    private final Map<String, EquipementPersistanceModel> equipements = new ConcurrentHashMap<>();

    private final EquipementPersistenceMapper persistenceMapper;

    public InMemoryEquipementRepository(EquipementPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Equipement equipement) {
        EquipementPersistanceModel model = persistenceMapper.toPersistence(equipement);
        equipements.put(model.id(),model);
    }

    @Override
    public Equipement fetchById(EquipementId id) {
        EquipementPersistanceModel model = equipements.get(id.value());
        if (model == null){
            throw new EquipementNotFoundException(id);
        }
        return persistenceMapper.toDomain(model);
    }

}
