package Runtime.equipement.application;

import Runtime.equipement.domain.Equipement;
import Runtime.equipement.domain.EquipementFactory;
import Runtime.equipement.domain.EquipementRepository;

public class CreateEquipementUseCase {

    private final EquipementFactory equipementFactory;
    private final EquipementRepository equipementRepository;
    private final EquipementOutPutMapper outPutMapper;

    public CreateEquipementUseCase(
            EquipementFactory equipementFactory,
            EquipementRepository equipementRepository,
            EquipementOutPutMapper outPutMapper) {
        this.equipementFactory = equipementFactory;
        this.equipementRepository = equipementRepository;
        this.outPutMapper = outPutMapper;
    }

    public EquipementOutPut execute(CreateEquipementCommand command){

        Equipement equipement =
                equipementFactory.create(
                        command.playerId(),
                        command.templateId(),
                        command.equipementType(),
                        command.name(),
                        command.weight()
                );

        equipementRepository.save(equipement);

        return outPutMapper.toOutput(equipement);
    }

}
