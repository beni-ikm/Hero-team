package runtime.lobby.application;

import runtime.lobby.domain.Lobby;
import runtime.lobby.domain.LobbyFactory;
import runtime.lobby.domain.LobbyRepository;
import runtime.lobby.domain.exception.AlreadyInLobbyException;
import runtime.lobby.domain.partOfLobby.PlayerId;

public class CreateLobbyUseCase {

    private final LobbyFactory lobbyFactory;
    private final LobbyRepository lobbyRepository;
    private final LobbyOutputMapper outputMapper;


    public CreateLobbyUseCase(
            LobbyFactory lobbyFactory,
            LobbyRepository lobbyRepository,
            LobbyOutputMapper outputMapper) {
        this.lobbyFactory = lobbyFactory;
        this.lobbyRepository = lobbyRepository;
        this.outputMapper = outputMapper;
    }

    public LobbyOutput execute(CreateLobbyCommand command){

        PlayerId playerId = new PlayerId(command.playerId());

        if(lobbyRepository.existsOpenLobbyByMember(playerId)){
            throw new AlreadyInLobbyException();
        }

        Lobby lobby = lobbyFactory.create(playerId);

        lobbyRepository.save(lobby);

        return outputMapper.toOutput(lobby);
    }
}
