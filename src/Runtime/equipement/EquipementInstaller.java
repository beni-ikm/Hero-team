package Runtime.equipement;

//import org.glassfish.jersey.server.ResourceConfig;
import Runtime.equipement.domain.EquipementRepository;
import Runtime.equipement.infrastructure.EquipementPersistenceMapper;
import Runtime.equipement.infrastructure.InMemoryEquipementRepository;

public class EquipementInstaller {

    private final EquipementRepository equipementRepository;


    public EquipementInstaller(EquipementRepository equipementRepository) {
        this.equipementRepository = new InMemoryEquipementRepository(new EquipementPersistenceMapper());
    }

    //TODO : faut installer glassfish pour pouvoir faire la même chose que le avait fait

}
