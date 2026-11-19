package runtime.player;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import runtime.player.api.PlayerResource;
import runtime.player.application.GetPlayerProfileUseCase;
import runtime.player.domain.PlayerRepository;
import runtime.player.infra.InMemoryPlayerRepository;
import runtime.shared.api.ApiExceptionMapper;
import runtime.shared.api.DevTokenAuthenticator;
import runtime.shared.api.TokenAuthenticator;

public class PlayerInstaller {

    public void install(ResourceConfig resourceConfig) {
        resourceConfig.register(PlayerResource.class);
        resourceConfig.register(ApiExceptionMapper.class);

        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(InMemoryPlayerRepository.class).to(PlayerRepository.class).in(Singleton.class);
                bind(GetPlayerProfileUseCase.class).to(GetPlayerProfileUseCase.class).in(Singleton.class);
                bind(DevTokenAuthenticator.class).to(TokenAuthenticator.class).in(Singleton.class);
            }
        });
    }
}