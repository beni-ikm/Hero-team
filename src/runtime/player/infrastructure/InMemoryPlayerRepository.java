package runtime.player.infrastructure;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPlayerRepository implements PlayerRepository {

    private final Map<String, PlayerPersistenceModel> accounts = new ConcurrentHashMap<>();

    public PlayerPersistenceMapper persistenceMapper;

    public InMemoryPlayerRepository(PlayerPersistenceMapper persistenceMapper) {
        this.persistenceMapper = persistenceMapper;
    }

    @Override
    public void save(Player player) {
        PlayerPersistenceModel model = persistenceMapper.toPersistence(player);
        accounts.put(model.playerId(), model);
    }
}
