package runtime.lobby;

import org.glassfish.jersey.server.ResourceConfig;
import runtime.lobby.api.LobbyExceptionMapper;
import runtime.lobby.api.LobbyResponseMapper;
import runtime.lobby.api.LobbyRessource;
import runtime.lobby.application.CreateLobbyUseCase;
import runtime.lobby.application.LobbyOutputMapper;
import runtime.lobby.domain.LobbyFactory;
import runtime.lobby.domain.LobbyRepository;
import runtime.lobby.infrastructure.InMemoryLobbyRepository;
import runtime.lobby.infrastructure.LobbyPersistenceMapper;

public class LobbyInstaller {

    public void install(ResourceConfig resourceConfig){
        LobbyPersistenceMapper persistenceMapper =
                new LobbyPersistenceMapper();

        LobbyRepository lobbyRepository =
                new InMemoryLobbyRepository(persistenceMapper);

        LobbyFactory lobbyFactory = new LobbyFactory();

        LobbyOutputMapper outputMapper = new LobbyOutputMapper();

        CreateLobbyUseCase createLobbyUseCase =
                new CreateLobbyUseCase(
                        lobbyFactory,
                        lobbyRepository,
                        outputMapper);


        LobbyRessource lobbyResource =
                new LobbyRessource(
                        createLobbyUseCase,
                        new LobbyResponseMapper()
                );

        resourceConfig.register(lobbyResource);
        resourceConfig.register(new LobbyExceptionMapper());
    }
}
