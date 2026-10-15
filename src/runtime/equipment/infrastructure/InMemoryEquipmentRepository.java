package runtime.equipment.infrastructure;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.EquipmentRepository;
import runtime.equipment.domain.exception.EquipmentNotFoundException;
import runtime.equipment.domain.partofequipment.EquipmentId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryEquipmentRepository implements EquipmentRepository {

    private final Map<String, EquipmentPersistenceModel> equipments = new ConcurrentHashMap<>();

    private final EquipmentPersistenceMapper persistenceMapper;

    public InMemoryEquipmentRepository(EquipmentPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Equipment equipment) {
        EquipmentPersistenceModel model = persistenceMapper.toPersistence(equipment);
        equipments.put(model.id(),model);
    }

    @Override
    public Equipment fetchById(EquipmentId id) {
        EquipmentPersistenceModel model = equipments.get(id.value());
        if (model == null){
            throw new EquipmentNotFoundException(id);
        }
        return persistenceMapper.toDomain(model);
    }

}
