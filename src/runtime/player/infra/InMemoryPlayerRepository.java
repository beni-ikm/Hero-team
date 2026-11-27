package runtime.player.infra;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerRepository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPlayerRepository implements PlayerRepository {
    private final Map<String, Player> players = new ConcurrentHashMap<>();

    @Override
    public Optional<Player> findById(String playerId) {
        return Optional.ofNullable(players.get(playerId));
    }

    @Override
    public void save(Player player) {
        players.put(player.id(), player);
    }
}