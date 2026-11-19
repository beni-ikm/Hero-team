package runtime.player.application;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerId;
import runtime.player.domain.PlayerRepository;
import runtime.player.domain.PlayerUserId;
import runtime.player.domain.exception.PlayerNotFoundException;

public class GetPlayerUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;

    public GetPlayerUseCase(
            PlayerRepository playerRepository, PlayerOutputMapper outputMapper) {
        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;
    }

    public PlayerOutput execute(GetPlayerQuery query) {
        PlayerId playerId = new PlayerId(query.playerId());
        PlayerUserId playerUserId = new PlayerUserId(query.userId());

        Player player = playerRepository.fetchById(playerId);

        if (!player.isOwnedBy(playerUserId)) {
            throw new PlayerNotFoundException(playerId);
        }

        return outputMapper.toOutput(player);

    }

}
