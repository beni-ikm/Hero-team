package runtime.lobby.domain;

import runtime.lobby.domain.partOfLobby.LobbyId;
import runtime.lobby.domain.partOfLobby.PlayerId;

public interface LobbyRepository {
    void save(Lobby lobby);

    boolean existsOpenLobbyByMember(PlayerId playerId);

    Lobby fetchById(LobbyId lobbyId);
}
