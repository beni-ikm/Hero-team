package runtime.equipementpackage.application;

public record EquipementOutPut (
        String id,
        String playerId,
        String templateId,
        String equipementType,
        String name,
        int weight
    ){}
