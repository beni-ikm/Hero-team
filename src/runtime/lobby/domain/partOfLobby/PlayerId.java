package runtime.lobby.domain.partOfLobby;

import java.util.Objects;

public record PlayerId(String value){

    public PlayerId{
        Objects.requireNonNull(value);
    }

}
