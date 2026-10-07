package Runtime.equipement.api.dto;

import jakarta.validation.constraints.NotNull;

public record CreateEquipementRequest(
        @NotNull String name,
        @NotNull String templateId,
        @NotNull String equipementType,
        @NotNull Integer weight
) {

}
