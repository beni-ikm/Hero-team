package Runtime.equipement.api;

import Runtime.equipement.api.dto.CreateEquipementRequest;
import Runtime.equipement.application.CreateEquipementCommand;

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
