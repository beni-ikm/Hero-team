package runtime.lobby.domain.partOfLobby;

import runtime.lobby.domain.exception.PlayerIdNotFoundException;

import java.util.Objects;

public record PlayerId(String value){

    public PlayerId{

        if(value == null || value.isBlank()) {
           throw new PlayerIdNotFoundException();
        }
        Objects.requireNonNull(value);
    }

}
