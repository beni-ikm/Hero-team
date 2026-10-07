package Runtime.equipement.infrastructure;

public record EquipementPersistanceModel(
        String id,
        String playerId,
        String templateId,
        String equipementType,
        String name,
        int weight) {
}
