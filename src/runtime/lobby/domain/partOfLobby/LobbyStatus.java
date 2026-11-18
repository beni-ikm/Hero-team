package runtime.lobby.domain.partOfLobby;

public record LobbyStatus(boolean open){

    public static LobbyStatus opened() {
        return new LobbyStatus(true);
    }

    public static LobbyStatus closed() {
        return new LobbyStatus(false);
    }

    public String value() {
        return open ? "OPEN" : "CLOSED";
    }

}
