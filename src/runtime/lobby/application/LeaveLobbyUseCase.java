package runtime.lobby.application;

import runtime.lobby.domain.LobbyRoom;
import runtime.lobby.domain.LobbyRoomRepository;
import runtime.lobby.domain.LobbyState;
import runtime.shared.api.ApiException;

import java.util.Objects;

public class LeaveLobbyUseCase {

    private final LobbyRoomRepository lobbyRepository;

    public LeaveLobbyUseCase(LobbyRoomRepository lobbyRepository) {
        this.lobbyRepository = Objects.requireNonNull(lobbyRepository);
    }

    public void execute(LeaveLobbyCommand command) {
        if (!command.requesterPlayerId().equals(command.targetPlayerId())) {
            throw new ApiException(403, "FORBIDDEN", "You can only remove yourself from a lobby.");
        }

        LobbyRoom lobby = lobbyRepository.findById(command.lobbyId())
                .orElseThrow(() -> new ApiException(404, "LOBBY_NOT_FOUND", "Lobby not found."));

        if (lobby.state() == LobbyState.STARTED) {
            throw new ApiException(409, "GAME_ALREADY_STARTED", "Cannot leave a lobby once the game has started.");
        }

        if (lobby.state() == LobbyState.CLOSED || !lobby.hasMember(command.targetPlayerId())) {
            throw new ApiException(404, "PLAYER_NOT_IN_LOBBY", "Player is not a member of this lobby.");
        }

        lobby.removeMember(command.targetPlayerId());
        lobbyRepository.save(lobby);
    }
}