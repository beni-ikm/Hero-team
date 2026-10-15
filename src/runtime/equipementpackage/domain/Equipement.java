package runtime.equipementpackage.domain;

import runtime.equipementpackage.domain.partofequipement.*;

import java.util.Objects;

public class Equipement {

    private final EquipementId id;
    private final PlayerId playerId;
    private final EquipementTemplateId templateId;
    private final EquipementType equipementType;
    private final EquipementName name;
    private final EquipementWeight weight;


    public Equipement(
            EquipementId id,
            PlayerId playerId,
            EquipementTemplateId templateId,
            EquipementType equipementType,
            EquipementName name,
            EquipementWeight weight) {
        this.id = Objects.requireNonNull(id);
        this.playerId = Objects.requireNonNull(playerId);
        this.templateId = Objects.requireNonNull(templateId);
        this.equipementType = Objects.requireNonNull(equipementType);
        this.name = Objects.requireNonNull(name);
        this.weight = Objects.requireNonNull(weight);

    }

    public boolean isOwnedBy(PlayerId player) { return playerId.equals(player);}

    public EquipementId id() { return id;}

    public PlayerId playerId() {return playerId; }

    public EquipementName name() { return name;}

    public EquipementType equipementType() {return equipementType;}

    public EquipementTemplateId templateId() { return templateId; }

    public EquipementWeight weight() {return weight;}

    public boolean equals(Object other) { return other instanceof Equipement equipement && id.equals(equipement.id);}

    public int hashCode() { return id.hashCode();}

}

