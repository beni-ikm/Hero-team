package runtime.lobby.domain.partOfLobby;

public record LobbyStatus(boolean value){

    public static LobbyStatus open() {
        return new LobbyStatus(true);
    }

    public static LobbyStatus close() {
        return new LobbyStatus(false);
    }

    public String valueToString() {
        return value ? "OPEN" : "CLOSED";
    }

}
