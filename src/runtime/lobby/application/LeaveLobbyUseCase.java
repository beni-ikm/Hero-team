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
            throw new ApiException(403, "FORBIDDEN", "Vous ne pouvez retirer que vous-même d'un lobby.");
        }

        LobbyRoom lobby = lobbyRepository.findById(command.lobbyId())
                .orElseThrow(() -> new ApiException(404, "LOBBY_NOT_FOUND", "Lobby introuvable."));

        if (lobby.state() == LobbyState.STARTED) {
            throw new ApiException(409, "GAME_ALREADY_STARTED", "Impossible de quitter un lobby une fois la partie lancée.");
        }

        if (lobby.state() == LobbyState.CLOSED || !lobby.hasMember(command.targetPlayerId())) {
            throw new ApiException(404, "PLAYER_NOT_IN_LOBBY", "Le joueur n'est pas membre de ce lobby.");
        }

        lobby.removeMember(command.targetPlayerId());
        lobbyRepository.save(lobby);
    }
}