package runtime.equipment;

import org.glassfish.jersey.server.ResourceConfig;
import runtime.equipment.api.*;
import runtime.equipment.application.CreateEquipmentUseCase;
import runtime.equipment.application.GetEquipmentUseCase;
import runtime.equipment.domain.EquipmentFactory;
import runtime.equipment.domain.EquipmentRepository;
import runtime.equipment.infrastructure.EquipmentPersistenceMapper;
import runtime.equipment.infrastructure.InMemoryEquipmentRepository;
import runtime.equipment.application.EquipmentOutPutMapper;

public class EquipmentInstaller {

    private final EquipmentRepository equipmentRepository;


    public EquipmentInstaller() {
        this.equipmentRepository = new InMemoryEquipmentRepository(new EquipmentPersistenceMapper());
    }

    public void install(ResourceConfig resourceConfig){

        EquipmentOutPutMapper outPutMapper = new EquipmentOutPutMapper();
        CreateEquipmentUseCase createEquipmentUseCase = 
                new CreateEquipmentUseCase(
                        new EquipmentFactory(), equipmentRepository, outPutMapper);
        GetEquipmentUseCase getEquipmentUseCase = 
                new GetEquipmentUseCase(equipmentRepository, outPutMapper);
        resourceConfig.register(
                new EquipmentResource(
                        createEquipmentUseCase,
                        getEquipmentUseCase,
                        new CreateEquipmentRequestMapper(),
                        new EquipmentResponseMapper()));
        resourceConfig.register(new EquipmentExceptionMapper());
        resourceConfig.register(new EquipmentNotFoundExceptionMapper());

    }
}
