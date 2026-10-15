package runtime.equipementpackage.application;

import runtime.equipementpackage.domain.Equipement;
import runtime.equipementpackage.domain.EquipementRepository;
import runtime.equipementpackage.domain.exception.EquipementNotFoundException;
import runtime.equipementpackage.domain.partofequipement.EquipementId;
import runtime.equipementpackage.domain.partofequipement.PlayerId;

public class GetEquipementUseCase {

    private final EquipementRepository equipementRepository;
    private final EquipementOutPutMapper outPutMapper;


    public GetEquipementUseCase(EquipementRepository equipementRepository, EquipementOutPutMapper outPutMapper) {
        this.equipementRepository = equipementRepository;
        this.outPutMapper = outPutMapper;
    }

    public EquipementOutPut execute(GetEquipementQuery query) {
        EquipementId equipementId = new EquipementId(query.equipementId());
        PlayerId playerId = new PlayerId(query.playerId());

        Equipement equipement = equipementRepository.fetchById(equipementId);

        if (!equipement.isOwnedBy(playerId)){
            throw new EquipementNotFoundException(equipementId);
        }

        return outPutMapper.toOutput(equipement);
    }


}
