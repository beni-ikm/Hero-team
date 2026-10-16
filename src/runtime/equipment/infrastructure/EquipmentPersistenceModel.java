package runtime.equipment.infrastructure;

public record EquipmentPersistenceModel(
        String id,
        String playerId,
        String templateId,
        String equipmentType,
        String name,
        int weight) {
}
