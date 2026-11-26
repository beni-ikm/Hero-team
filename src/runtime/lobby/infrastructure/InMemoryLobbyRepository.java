package runtime.lobby.infrastructure;

import runtime.lobby.domain.Lobby;
import runtime.lobby.domain.LobbyRepository;
import runtime.lobby.domain.exception.LobbyNotFoundException;
import runtime.lobby.domain.partOfLobby.LobbyId;
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

    @Override
    public Lobby fetchById(LobbyId lobbyId) {
        LobbyPersistenceModel model = lobbies.get(lobbyId.value());
        if(model == null) {
            throw new LobbyNotFoundException(lobbyId);
        }
        return persistenceMapper.toDomain(model);
    }
}
