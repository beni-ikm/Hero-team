package runtime.lobby.domain;


import runtime.lobby.domain.partOfLobby.LobbyId;
import runtime.lobby.domain.partOfLobby.LobbyStatus;
import runtime.lobby.domain.partOfLobby.PlayerId;

import java.util.List;

public class Lobby {

    private static final int MAX_PLAYERS = 4;

    private final LobbyId id;
    private final PlayerId host;
    private final List<PlayerId> members;
    private final LobbyStatus status;

    public Lobby(LobbyId id, PlayerId host, List<PlayerId> members, LobbyStatus status) {
        this.id = id;
        this.host = host;
        this.members = members;
        this.status = status;
    }

    public LobbyId id() {return id;}

    public PlayerId host() {return host;}

    public List<PlayerId> members() {return members;}

    public LobbyStatus status() {return status;}

    public int availableSeats() {return MAX_PLAYERS - members.size();}
}
