package runtime.player.application;

import runtime.player.domain.Player;

public class PlayerOutputMapper {

    public PlayerOutput toOutput(Player player) {
        return new PlayerOutput(
                player.playerId().value(),
                player.playerPseudonym().value(),
                player.playerEmail().value(),
                player.playerPassword().value());
    }

}
