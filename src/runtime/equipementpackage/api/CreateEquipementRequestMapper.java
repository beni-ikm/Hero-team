package runtime.equipementpackage.api;

import runtime.equipementpackage.api.dto.CreateEquipementRequest;
import runtime.equipementpackage.application.CreateEquipementCommand;

public class CreateEquipementRequestMapper {

    public CreateEquipementCommand toCommand(
            String playerId, CreateEquipementRequest request){
        return new CreateEquipementCommand(
                playerId,
                request.templateId(),
                request.equipementType(),
                request.name(),
                request.weight()
        );

    }
}
