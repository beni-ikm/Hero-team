package runtime.player.application;

import runtime.player.domain.*;

public class CreatePlayerUseCase {

    private final PlayerRepository playerRepository;
    private final PlayerOutputMapper outputMapper;
    private final PasswordHasher passwordHasher;

    public CreatePlayerUseCase(
            PlayerRepository playerRepository,
            PlayerOutputMapper outputMapper,
            PasswordHasher passwordHasher) {

        this.playerRepository = playerRepository;
        this.outputMapper = outputMapper;
        this.passwordHasher = passwordHasher;

    }

    public PlayerOutput execute(CreatePlayerCommand command) {

        Player player = new Player(
                PlayerId.generate(),
                new PlayerPseudonym(command.pseudonym()),
                new PlayerEmail(command.email()),
                PlayerPassword.fromRawPassword(command.password(), passwordHasher));


        playerRepository.save(player);

        return outputMapper.toOutput(player);

    }

}
