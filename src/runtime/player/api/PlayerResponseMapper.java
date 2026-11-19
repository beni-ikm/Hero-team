package runtime.player.api;

import runtime.player.api.dto.GetPlayerResponse;
import runtime.player.application.PlayerOutput;

public class PlayerResponseMapper {

    public GetPlayerResponse toResponse(PlayerOutput player) {
        return new GetPlayerResponse(
                player.id(),
                player.pseudonym(),
                player.email());
    }

}
