package runtime.lobby.infrastructure;

import runtime.lobby.domain.Lobby;
import runtime.lobby.domain.LobbyRepository;
import runtime.lobby.domain.partOfLobby.PlayerId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLobbyRepository implements LobbyRepository {

    private final Map<String, LobbyPersistenceModel> lobbies =
            new ConcurrentHashMap<>();


    private final LobbyPersistenceMapper persistenceMapper;

    public InMemoryLobbyRepository(LobbyPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Lobby lobby) {

        LobbyPersistenceModel model =
                persistenceMapper.toPersistence(lobby);

        lobbies.put(model.id(), model);
    }

    @Override
    public boolean existsOpenLobbyByMember(PlayerId playerId) {

        return lobbies.values().stream()
                .anyMatch(lobby -> lobby.open()
                && lobby.members().contains(playerId.value()));
    }
}
