package runtime.lobby.domain.exception;

public class PlayerIdNotFoundException extends LobbyException {
    public PlayerIdNotFoundException() {super("Player Id was not found");
    }
}
