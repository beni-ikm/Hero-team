package runtime.lobby.domain.exception;

public class LobbyClosedException extends LobbyException {
    public LobbyClosedException() {
        super("The lobby is closed");
    }
}
