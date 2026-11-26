package runtime.lobby.api;

import runtime.lobby.api.dto.LobbyResponse;
import runtime.lobby.application.LobbyOutput;

import java.util.List;

public class LobbyResponseMapper {

    public LobbyResponse toResponse(LobbyOutput output){

        List<LobbyResponse.LobbyPlayerResponse> players =
            output.players().stream()
                    .map(player -> new LobbyResponse.LobbyPlayerResponse(
                            player.playerId(),
                            player.nickname(),
                            player.hero() == null
                                    ? null : new LobbyResponse.HeroResponse(
                                    player.hero().id(),
                                    player.hero().name()
                            )
                    )).toList();


        return new LobbyResponse(
                output.id(),
                output.state(),
                output.hostId(),
                players,
                output.availableSeats()
        );
    }


}
