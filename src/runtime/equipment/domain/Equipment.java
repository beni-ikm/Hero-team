package runtime.equipment.domain;

import runtime.equipment.domain.partofequipment.*;

import java.util.Objects;

public class Equipment {

    private final EquipmentId id;
    private final PlayerId playerId;
    private final EquipmentTemplateId templateId;
    private final EquipmentType equipmentType;
    private final EquipmentName name;
    private final EquipmentWeight weight;


    public Equipment(
            EquipmentId id,
            PlayerId playerId,
            EquipmentTemplateId templateId,
            EquipmentType equipmentType,
            EquipmentName name,
            EquipmentWeight weight) {
        this.id = Objects.requireNonNull(id);
        this.playerId = Objects.requireNonNull(playerId);
        this.templateId = Objects.requireNonNull(templateId);
        this.equipmentType = Objects.requireNonNull(equipmentType);
        this.name = Objects.requireNonNull(name);
        this.weight = Objects.requireNonNull(weight);

    }

    public boolean isOwnedBy(PlayerId player) { return playerId.equals(player);}

    public EquipmentId id() { return id;}

    public PlayerId playerId() {return playerId; }

    public EquipmentName name() { return name;}

    public EquipmentType equipmentType() {return equipmentType;}

    public EquipmentTemplateId templateId() { return templateId; }

    public EquipmentWeight weight() {return weight;}

    public boolean equals(Object other) { return other instanceof Equipment equipment && id.equals(equipment.id);}

    public int hashCode() { return id.hashCode();}

}

