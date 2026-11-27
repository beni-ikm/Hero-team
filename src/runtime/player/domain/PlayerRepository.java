package runtime.player.domain;

import java.util.Optional;

public interface PlayerRepository {
    Optional<Player> findById(String playerId);
    void save(Player player);
}
