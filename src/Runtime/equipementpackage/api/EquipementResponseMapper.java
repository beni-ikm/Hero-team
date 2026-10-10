package Runtime.equipementpackage.api;

import Runtime.equipementpackage.api.dto.GetEquipementResponse;
import Runtime.equipementpackage.application.EquipementOutPut;

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
