package Runtime.lobby.domain.exception;

public class LobbyNotFoundException extends RuntimeException {
    public LobbyNotFoundException(String message) {
        super(message);
    }
}
