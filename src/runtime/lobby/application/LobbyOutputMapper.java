package runtime.lobby.application;

import runtime.lobby.domain.Lobby;

import java.util.List;

public class LobbyOutputMapper {

    public LobbyOutput toOutput(Lobby lobby){

        List<LobbyOutput.PlayerOutput> players = lobby.members().stream()
                .map(playerId -> new LobbyOutput.PlayerOutput(
                        playerId.value(),
                        null,
                        null
                )).toList();


        return new LobbyOutput(
                lobby.id().value(),
                lobby.status().valueToString(),
                lobby.host().value(),
                players,
                lobby.availableSeats()
        );
    }


}
