package runtime.lobby.api.dto;

import java.util.List;

public record LobbyResponse(
        String id,
        String state,
        String host,
        List<LobbyPlayerResponse> players,
        int availableSeats
){

    public record LobbyPlayerResponse(
            String playerId,
            String pseudonym,
            HeroResponse hero
    ) {}

    public record HeroResponse(
            String id,
            String name
    ) {}
}
