package runtime.lobby.domain.exception;

public class LobbyFullException extends LobbyException {
    public LobbyFullException() {
        super("The lobby you joined is full");
    }
}
