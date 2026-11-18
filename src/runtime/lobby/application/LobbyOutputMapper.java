package runtime.lobby.application;

import runtime.lobby.domain.Lobby;
import runtime.lobby.domain.partOfLobby.PlayerId;

import java.util.List;

public class LobbyOutputMapper {

    public LobbyOutput toOutPut(Lobby lobby){

        List<LobbyOutput.PlayerOutput> players = lobby.members().stream()
                .map(playerId -> new LobbyOutput.PlayerOutput(
                        playerId.value(),
                        null,
                        null
                )).toList();


        return new LobbyOutput(
                lobby.id().value(),
                lobby.status().value(),
                lobby.host().value(),
                players,
                lobby.availableSeats()
        );
    }


}
