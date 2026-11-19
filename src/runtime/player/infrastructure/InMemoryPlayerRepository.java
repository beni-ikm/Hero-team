package runtime.player.infrastructure;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerId;
import runtime.player.domain.PlayerRepository;
import runtime.player.domain.exception.PlayerNotFoundException;

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
        accounts.put(model.id(), model);
    }

    @Override
    public Player fetchById(PlayerId id) {
        PlayerPersistenceModel model = accounts.get(id.value());
        if (model == null) {
            throw new PlayerNotFoundException(id);
        }
        return persistenceMapper.toDomain(model);
    }

}
