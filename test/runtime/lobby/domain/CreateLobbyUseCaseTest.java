package runtime.lobby.domain;

import org.junit.jupiter.api.Test;
import runtime.lobby.application.CreateLobbyCommand;
import runtime.lobby.application.CreateLobbyUseCase;
import runtime.lobby.application.LobbyOutputMapper;
import runtime.lobby.domain.exception.AlreadyInLobbyException;
import runtime.lobby.domain.partOfLobby.PlayerId;
import runtime.lobby.infrastructure.InMemoryLobbyRepository;
import runtime.lobby.infrastructure.LobbyPersistenceMapper;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CreateLobbyUseCaseTest {

    private final LobbyFactory lobbyFactory = new LobbyFactory();


    private final InMemoryLobbyRepository lobbyRepository =
            new InMemoryLobbyRepository(new LobbyPersistenceMapper());

    private final LobbyOutputMapper outputMapper = new LobbyOutputMapper();

    private final CreateLobbyUseCase createLobbyUseCase =
            new CreateLobbyUseCase(
                    lobbyFactory,
                    lobbyRepository,
                    outputMapper
            );

    @Test
    void multipleLobbies_SameOwner_isRefused(){

        PlayerId playerId = new PlayerId("p-7f3a");

        CreateLobbyCommand command = new CreateLobbyCommand(playerId.value());

        createLobbyUseCase.execute(command);

        assertThrows(
                AlreadyInLobbyException.class,
                () -> createLobbyUseCase.execute(command)
        );


    }


}
