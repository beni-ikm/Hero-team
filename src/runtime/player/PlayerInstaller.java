package runtime.player;

import org.glassfish.jersey.server.ResourceConfig;
import runtime.player.api.*;
import runtime.player.application.PlayerOutputMapper;
import runtime.player.application.CreatePlayerUseCase;
import runtime.player.domain.PlayerRepository;
import runtime.player.infrastructure.PlayerPersistenceMapper;
import runtime.player.infrastructure.InMemoryPlayerRepository;
import runtime.player.infrastructure.security.Argon2PasswordHasher;

public class PlayerInstaller {

    private final PlayerRepository playerRepository;

    public PlayerInstaller() {
        this.playerRepository = new InMemoryPlayerRepository(new PlayerPersistenceMapper());
    }

    public void install(ResourceConfig resourceConfig) {

        PlayerOutputMapper outputMapper =
                new PlayerOutputMapper();
        CreatePlayerUseCase createAccountUseCase =
                new CreatePlayerUseCase(
                        playerRepository,
                        outputMapper,
                        new Argon2PasswordHasher());

        resourceConfig.register(
                new PlayerResource(
                        createAccountUseCase,
                        new CreatePlayerRequestMapper()));

        resourceConfig.register(new PlayerExceptionMapper());
    }

}
