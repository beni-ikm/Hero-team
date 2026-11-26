package runtime.lobby.domain;

import runtime.lobby.domain.partOfLobby.LobbyId;
import runtime.lobby.domain.partOfLobby.LobbyStatus;
import runtime.lobby.domain.partOfLobby.PlayerId;

import java.util.List;

public class LobbyFactory {

    public Lobby create(PlayerId playerId){

        return new Lobby(
                LobbyId.generate(),
                playerId,
                List.of(playerId),
                LobbyStatus.open()
        );

    }


}
