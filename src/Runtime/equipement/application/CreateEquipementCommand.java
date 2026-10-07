package Runtime.equipement.application;

public record CreateEquipementCommand (
        String playerId,
        String templateId,
        String equipementType,
        String name,
        int weight
) {

}
