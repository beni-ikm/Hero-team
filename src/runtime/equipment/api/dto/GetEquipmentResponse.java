package runtime.equipment.api.dto;

public record GetEquipmentResponse(
        String id,
        String templeId,
        String equipmentType,
        String name,
        int weight) {
}
