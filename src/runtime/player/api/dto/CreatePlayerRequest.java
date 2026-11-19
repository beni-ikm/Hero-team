package runtime.player.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import runtime.player.domain.PlayerEmail;
import runtime.player.domain.PlayerPassword;

public record CreatePlayerRequest(
        @NotNull String pseudonym,
        @NotNull @Valid PlayerEmail email,
        @NotNull PlayerPassword password) {
}

