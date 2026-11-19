package runtime.lobby.domain;

import org.junit.jupiter.api.Test;
import runtime.lobby.domain.partOfLobby.PlayerId;


import static org.junit.jupiter.api.Assertions.*;

public class LobbyFactoryTest {

    private final LobbyFactory lobbyFactory = new LobbyFactory();

    @Test
    void firstPlayer_isOwner_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(playerId, lobby.host());

    }

    @Test
    void secondPlayer_isOwner_isRefused(){

        PlayerId playerId = new PlayerId("p-7f3a");
        PlayerId playerId2 = new PlayerId("p-7h5b");


        Lobby lobby = lobbyFactory.create(playerId);

        assertNotEquals(playerId2, lobby.host());

    }


    @Test
    void onePlayer_LobbySize1_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(1, lobby.members().size());

    }

    @Test
    void lobbyOwner_IsFirstMember_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(playerId, lobby.members().getFirst());
    }



    @Test
    void availableSeats_3SeatsAvailable_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(3, lobby.availableSeats());

    }


}
