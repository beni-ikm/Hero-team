package runtime.equipementpackage.application;

public record CreateEquipementCommand (
        String playerId,
        String templateId,
        String equipementType,
        String name,
        int weight
) {

}
