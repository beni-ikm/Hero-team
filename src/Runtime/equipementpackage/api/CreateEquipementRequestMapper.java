package Runtime.equipementpackage.api;

import Runtime.equipementpackage.api.dto.CreateEquipementRequest;
import Runtime.equipementpackage.application.CreateEquipementCommand;

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
