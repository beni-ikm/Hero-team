package runtime.equipment.api.dto;

import jakarta.validation.constraints.NotNull;

public record CreateEquipmentRequest(
        @NotNull String name,
        @NotNull String templateId,
        @NotNull String equipmentType,
        @NotNull Integer weight
) {

}
