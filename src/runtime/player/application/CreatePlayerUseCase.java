package runtime.player.application;

import runtime.player.domain.*;

public class CreatePlayerUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;

    public CreatePlayerUseCase(
            PlayerRepository playerRepository,
            PlayerOutputMapper outputMapper) {

        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;

    }

    public PlayerOutput execute(CreatePlayerCommand command) {

        Player player = new Player(
                PlayerId.generate(),
                new PlayerPseudonym(command.pseudonym()),
                new PlayerEmail(command.email()),
                new PlayerPassword(command.password()));


        playerRepository.save(player);

        return outputMapper.toOutput(player);

    }

}
