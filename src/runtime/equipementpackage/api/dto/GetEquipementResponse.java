package runtime.equipementpackage.api.dto;

public record GetEquipementResponse(
        String id,
        String templeId,
        String equipementType,
        String name,
        int weight) {
}
