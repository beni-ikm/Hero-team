package runtime.equipment.application;

public record GetEquipmentQuery(
        String equipmentId,
        String playerId) {
}
