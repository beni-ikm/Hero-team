package runtime.equipementpackage.domain;

import runtime.equipementpackage.domain.partofequipement.*;

public class EquipementFactory {

    public Equipement create(
            String playerId,
            String templateId,
            String equipementType,
            String name,
            int weight) {
        return new Equipement(
                EquipementId.generate(),
                new PlayerId(playerId),
                new EquipementTemplateId(templateId),
                EquipementType.of(equipementType),
                new EquipementName(name),
                new EquipementWeight(weight)
        );
    }
}
