package runtime.equipment.application;

import runtime.equipment.domain.Equipment;
import runtime.equipment.domain.EquipmentRepository;
import runtime.equipment.domain.exception.EquipmentNotFoundException;
import runtime.equipment.domain.partofequipment.EquipmentId;
import runtime.equipment.domain.partofequipment.PlayerId;

public class GetEquipmentUseCase {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentOutPutMapper outPutMapper;


    public GetEquipmentUseCase(EquipmentRepository equipmentRepository, EquipmentOutPutMapper outPutMapper) {
        this.equipmentRepository = equipmentRepository;
        this.outPutMapper = outPutMapper;
    }

    public EquipmentOutPut execute(GetEquipmentQuery query) {
        EquipmentId equipmentId = new EquipmentId(query.equipmentId());
        PlayerId playerId = new PlayerId(query.playerId());

        Equipment equipment = equipmentRepository.fetchById(equipmentId);

        if (!equipment.isOwnedBy(playerId)){
            throw new EquipmentNotFoundException(equipmentId);
        }

        return outPutMapper.toOutput(equipment);
    }


}
