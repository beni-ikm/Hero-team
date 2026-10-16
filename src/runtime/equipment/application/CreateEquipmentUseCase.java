package runtime.equipment.application;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.EquipmentFactory;
import runtime.equipment.domain.EquipmentRepository;

public class CreateEquipmentUseCase {

    private final EquipmentFactory equipmentFactory;
    private final EquipmentRepository equipmentRepository;
    private final EquipmentOutPutMapper outPutMapper;

    public CreateEquipmentUseCase(
            EquipmentFactory equipmentFactory,
            EquipmentRepository equipmentRepository,
            EquipmentOutPutMapper outPutMapper) {
        this.equipmentFactory = equipmentFactory;
        this.equipmentRepository = equipmentRepository;
        this.outPutMapper = outPutMapper;
    }

    public EquipmentOutPut execute(CreateEquipmentCommand command){

        Equipment equipment =
                equipmentFactory.create(
                        command.playerId(),
                        command.templateId(),
                        command.equipmentType(),
                        command.name(),
                        command.weight()
                );

        equipmentRepository.save(equipment);

        return outPutMapper.toOutput(equipment);
    }

}
