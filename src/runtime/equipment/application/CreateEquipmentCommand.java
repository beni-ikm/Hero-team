package runtime.equipment.application;

public record CreateEquipmentCommand(
        String playerId,
        String templateId,
        String equipmentType,
        String name,
        int weight
) {

}
