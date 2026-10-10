package Runtime.equipementpackage;

//import org.glassfish.jersey.server.ResourceConfig;
import Runtime.equipementpackage.domain.EquipementRepository;
import Runtime.equipementpackage.infrastructure.EquipementPersistenceMapper;
import Runtime.equipementpackage.infrastructure.InMemoryEquipementRepository;

public class EquipementInstaller {

    private final EquipementRepository equipementRepository;


    public EquipementInstaller(EquipementRepository equipementRepository) {
        this.equipementRepository = new InMemoryEquipementRepository(new EquipementPersistenceMapper());
    }

    //TODO : faut installer glassfish pour pouvoir faire la même chose que le avait fait

}
