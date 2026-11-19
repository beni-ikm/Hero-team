package runtime.lobby.domain;

import java.util.Optional;

public interface LobbyRoomRepository {
    Optional<LobbyRoom> findById(String lobbyId);
    void save(LobbyRoom lobby);
}