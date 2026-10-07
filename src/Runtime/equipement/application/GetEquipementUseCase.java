package Runtime.equipement.application;

import Runtime.equipement.domain.Equipement;
import Runtime.equipement.domain.EquipementRepository;
import Runtime.equipement.domain.exception.EquipementNotFoundException;
import Runtime.equipement.domain.partofequipement.EquipementId;
import Runtime.equipement.domain.partofequipement.PlayerId;

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
