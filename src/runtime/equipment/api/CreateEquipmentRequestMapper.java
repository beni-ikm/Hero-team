package runtime.equipment.api;

import runtime.equipment.api.dto.CreateEquipmentRequest;
import runtime.equipment.application.CreateEquipmentCommand;

public class CreateEquipmentRequestMapper {

    public CreateEquipmentCommand toCommand(
            String playerId, CreateEquipmentRequest request){
        return new CreateEquipmentCommand(
                playerId,
                request.templateId(),
                request.equipmentType(),
                request.name(),
                request.weight()
        );

    }
}
