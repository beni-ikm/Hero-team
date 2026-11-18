package runtime.lobby.domain.exception;

public class AlreadyInLobbyException extends LobbyException {
    public AlreadyInLobbyException() {
        super("Already in lobby");
    }
}
