package runtime.lobby.domain;

import runtime.lobby.domain.partOfLobby.PlayerId;

import java.util.Optional;

public interface LobbyRepository {
    void save(Lobby lobby);

    boolean existsOpenLobbyByMember(PlayerId playerId);
}
