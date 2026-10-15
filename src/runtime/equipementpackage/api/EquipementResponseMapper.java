package runtime.equipementpackage.api;

import runtime.equipementpackage.api.dto.GetEquipementResponse;
import runtime.equipementpackage.application.EquipementOutPut;

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
