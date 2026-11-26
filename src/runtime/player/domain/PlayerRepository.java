package runtime.player.domain;

import java.util.Optional;

public class PlayerRepository {
    Optional<Player> findById(String playerId);
    void save(Player player);
}
