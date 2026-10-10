package Runtime.equipementpackage.infrastructure;

import Runtime.equipementpackage.domain.Equipement;
import Runtime.equipementpackage.domain.EquipementRepository;
import Runtime.equipementpackage.domain.exception.EquipementNotFoundException;
import Runtime.equipementpackage.domain.partofequipement.EquipementId;

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
