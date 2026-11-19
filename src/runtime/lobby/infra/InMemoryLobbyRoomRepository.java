package runtime.lobby.infra;

import runtime.lobby.domain.LobbyRoom;
import runtime.lobby.domain.LobbyRoomRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRoomRepository implements LobbyRoomRepository {
    private final Map<String, LobbyRoom> lobbies = new ConcurrentHashMap<>();

    @Override
    public Optional<LobbyRoom> findById(String lobbyId) {
        return Optional.ofNullable(lobbies.get(lobbyId));
    }

    @Override
    public void save(LobbyRoom lobby) {
        lobbies.put(lobby.id(), lobby);
    }
}