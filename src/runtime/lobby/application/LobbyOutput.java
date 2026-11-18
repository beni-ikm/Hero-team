package runtime.lobby.application;

import java.util.List;

public record LobbyOutput(
        String id,
        String state,
        String hostId,
        List<PlayerOutput> players,
        int availableSeats
) {

    public record PlayerOutput(
            String playerId,
            String pseudonym,
            HeroOutput hero
    ) {}

    public record HeroOutput(
            String id,
            String name
    ) {}
}