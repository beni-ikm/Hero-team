package runtime.equipment.api;

import runtime.equipment.api.dto.GetEquipmentResponse;
import runtime.equipment.application.EquipmentOutPut;

public class EquipmentResponseMapper {

    public GetEquipmentResponse toResponse(EquipmentOutPut equipment){
        return new GetEquipmentResponse(
                equipment.id(),
                equipment.templateId(),
                equipment.equipmentType(),
                equipment.name(),
                equipment.weight()
        );
    }
}
