package runtime.equipment.application;

public record EquipmentOutPut(
        String id,
        String playerId,
        String templateId,
        String equipmentType,
        String name,
        int weight
    ){}
