package runtime.lobby.domain.partOfLobby;

import java.util.Objects;
import java.util.UUID;

public record LobbyId (String value){

    public LobbyId {
        Objects.requireNonNull(value);
    }
    public static LobbyId generate() { return new LobbyId("L-"+UUID.randomUUID().toString());}
}
