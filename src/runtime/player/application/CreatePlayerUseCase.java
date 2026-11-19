package runtime.player.application;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerFactory;
import runtime.player.domain.PlayerRepository;

public class CreatePlayerUseCase {

    private final PlayerFactory playerFactory;
    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;

    public CreatePlayerUseCase(
            PlayerFactory playerFactory,
            PlayerRepository playerRepository,
            PlayerOutputMapper outputMapper) {

        this.playerFactory = playerFactory;
        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;

    }

    public PlayerOutput execute(CreatePlayerCommand command) {

        Player player =
                playerFactory.create(
                        command.playerUserId(),
                        command.pseudonym(),
                        command.email(),
                        command.password());

        playerRepository.save(player);

        return outputMapper.toOutput(player);

    }

}
