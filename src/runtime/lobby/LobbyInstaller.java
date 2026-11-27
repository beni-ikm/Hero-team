package runtime.lobby;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import runtime.lobby.api.LobbyResource;
import runtime.lobby.application.LeaveLobbyUseCase;
import runtime.lobby.domain.LobbyRoomRepository;
import runtime.lobby.infra.InMemoryLobbyRoomRepository;
import runtime.shared.api.ApiExceptionMapper;

public class LobbyInstaller {

    public void install(ResourceConfig resourceConfig) {
        resourceConfig.register(LobbyResource.class);
        resourceConfig.register(ApiExceptionMapper.class);

        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(InMemoryLobbyRoomRepository.class).to(LobbyRoomRepository.class).in(Singleton.class);
                bind(LeaveLobbyUseCase.class).to(LeaveLobbyUseCase.class).in(Singleton.class);
            }
        });
    }
}
