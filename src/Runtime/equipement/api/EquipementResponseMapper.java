package Runtime.equipement.api;

import Runtime.equipement.api.dto.GetEquipementResponse;
import Runtime.equipement.application.EquipementOutPut;
import Runtime.equipement.application.GetEquipementUseCase;

public class EquipementResponseMapper {

    public GetEquipementResponse toResponse(EquipementOutPut equipement){
        return new GetEquipementResponse(
                equipement.id(),
                equipement.templateId(),
                equipement.equipementType(),
                equipement.name(),
                equipement.weight()
        );
    }
}
