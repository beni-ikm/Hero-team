package runtime.equipment;

//import org.glassfish.jersey.server.ResourceConfig;
import runtime.equipment.domain.EquipmentRepository;
import runtime.equipment.infrastructure.EquipmentPersistenceMapper;
import runtime.equipment.infrastructure.InMemoryEquipmentRepository;

public class EquipmentInstaller {

    private final EquipmentRepository equipmentRepository;


    public EquipmentInstaller(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = new InMemoryEquipmentRepository(new EquipmentPersistenceMapper());
    }

    //TODO : faut installer GlassFish pour pouvoir faire la même chose que le avait fait

}
