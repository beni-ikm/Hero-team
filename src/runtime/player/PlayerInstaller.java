package runtime.player;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import runtime.player.api.*;
import runtime.player.application.PlayerOutputMapper;
import runtime.player.application.CreatePlayerUseCase;
import runtime.player.application.GetPlayerUseCase;
import runtime.player.domain.PlayerFactory;
import runtime.player.api.PlayerResource;
import runtime.player.application.GetPlayerProfileUseCase;
import runtime.player.domain.PlayerRepository;
import runtime.player.infrastructure.PlayerPersistenceMapper;
import runtime.player.infrastructure.InMemoryPlayerRepository;
import runtime.player.infrastructure.security.Argon2PasswordHasher;
import runtime.shared.api.ApiExceptionMapper;
import runtime.shared.api.DevTokenAuthenticator;
import runtime.shared.api.TokenAuthenticator;

public class PlayerInstaller {

    private final PlayerRepository playerRepository;

    public PlayerInstaller() {
        this.playerRepository = new InMemoryPlayerRepository(new PlayerPersistenceMapper());
    }

    public void install(ResourceConfig resourceConfig) {
        resourceConfig.register(PlayerResource.class);
        resourceConfig.register(ApiExceptionMapper.class);
        PlayerOutputMapper outputMapper =
                new PlayerOutputMapper();
        CreatePlayerUseCase createAccountUseCase =
                new CreatePlayerUseCase(
                        playerRepository,
                        outputMapper,
                        new Argon2PasswordHasher());
                        new PlayerFactory(), playerRepository, outputMapper);
        GetPlayerUseCase getPlayerUseCase =
                new GetPlayerUseCase(playerRepository, outputMapper);

        resourceConfig.register(
                new PlayerResource(
                        createAccountUseCase,
                        new CreatePlayerRequestMapper(),
                        getPlayerUseCase,
                        new PlayerResponseMapper())
        );
        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(runtime.player.infra.InMemoryPlayerRepository.class).to(PlayerRepository.class).in(Singleton.class);
                bind(GetPlayerProfileUseCase.class).to(GetPlayerProfileUseCase.class).in(Singleton.class);
                bind(DevTokenAuthenticator.class).to(TokenAuthenticator.class).in(Singleton.class);
            }
        });

        resourceConfig.register(new PlayerExceptionMapper());
        resourceConfig.register(new PlayerNotFoundExceptionMapper());
    }

}
