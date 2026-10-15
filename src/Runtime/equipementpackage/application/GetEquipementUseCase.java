package Runtime.equipementpackage.application;

import Runtime.equipementpackage.domain.Equipement;
import Runtime.equipementpackage.domain.EquipementRepository;
import Runtime.equipementpackage.domain.exception.EquipementNotFoundException;
import Runtime.equipementpackage.domain.partofequipement.EquipementId;
import Runtime.equipementpackage.domain.partofequipement.PlayerId;

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
