package runtime.equipementpackage;

//import org.glassfish.jersey.server.ResourceConfig;
import runtime.equipementpackage.domain.EquipementRepository;
import runtime.equipementpackage.infrastructure.EquipementPersistenceMapper;
import runtime.equipementpackage.infrastructure.InMemoryEquipementRepository;

public class EquipementInstaller {

    private final EquipementRepository equipementRepository;


    public EquipementInstaller(EquipementRepository equipementRepository) {
        this.equipementRepository = new InMemoryEquipementRepository(new EquipementPersistenceMapper());
    }

    //TODO : faut installer glassfish pour pouvoir faire la même chose que le avait fait

}
