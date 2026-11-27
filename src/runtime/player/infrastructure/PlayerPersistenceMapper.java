package runtime.player.infrastructure;

import runtime.player.domain.*;

public class PlayerPersistenceMapper {

    public PlayerPersistenceModel toPersistence(Player player) {
        return new PlayerPersistenceModel(
                player.playerId().value(),
                player.playerPseudonym().value(),
                player.playerEmail().value(),
                player.playerPassword().value());
    }

    public Player toDomain(PlayerPersistenceModel model) {
        return new Player(
                new PlayerId(model.playerId()),
                new PlayerPseudonym(model.pseudonym()),
                new PlayerEmail(model.email()),
                new PlayerPassword(model.password()));
    }

}
