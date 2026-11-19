package runtime.lobby.domain.exception;

import runtime.lobby.domain.partOfLobby.LobbyId;

public class LobbyNotFoundException extends LobbyException {
    public LobbyNotFoundException(LobbyId id) {
        super("Lobby with id "+ id.value() + " was not found");
    }
}
