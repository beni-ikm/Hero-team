package runtime.lobby.infrastructure;

import runtime.lobby.domain.Lobby;
import runtime.lobby.domain.partOfLobby.LobbyId;
import runtime.lobby.domain.partOfLobby.LobbyStatus;
import runtime.lobby.domain.partOfLobby.PlayerId;

public class LobbyPersistenceMapper {

    public LobbyPersistenceModel toPersistence(Lobby lobby){

        return new LobbyPersistenceModel(
                lobby.id().value(),
                lobby.host().value(),
                lobby.members().stream()
                        .map(PlayerId::value)
                        .toList(),
                lobby.status().value().equals("OPEN")
        );
    }

    public Lobby toDomain(LobbyPersistenceModel model){

        return new Lobby(
                new LobbyId(model.id()),
                new PlayerId(model.host()),
                model.members().stream()
                        .map(PlayerId::new)
                        .toList(),
                model.open() ? LobbyStatus.opened() : LobbyStatus.closed()
        );
    }

}
