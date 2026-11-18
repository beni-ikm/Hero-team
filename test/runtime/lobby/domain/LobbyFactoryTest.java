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

    /*
    @Test
    void fivePlayer_InOneLobby_isRefused(){

        PlayerId playerId = new PlayerId("p-7f3a");
        PlayerId playerId2 = new PlayerId("p-7h5b");
        PlayerId playerId3 = new PlayerId("p-6h5b");
        PlayerId playerId4 = new PlayerId("p-8h5b");
        PlayerId playerId5 = new PlayerId("p-9h5b");

        Lobby lobby = lobbyFactory.create(playerId);

        lobby.addMember(playerId2);
        lobby.addMember(playerId3);
        lobby.addMember(playerId4);


        assertThrows(LobbyFullException.class,
                () -> lobby.addMember(playerId5));

    }*/


    @Test
    void onePlayer_LobbySize1_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(1, lobby.members().size());

    }

    @Test
    void lobbyOwner_IsFirstInLobby_isRefused(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(playerId, lobby.members().get(0));
    }

    /* would work if you could add members
    @Test
    void lobbyOwner_IsSecondInLobby_isRefused(){

        PlayerId playerId = new PlayerId("p-7f3a");
        PlayerId playerId2 = new PlayerId("p-7f5a");

        Lobby lobby = lobbyFactory.create(playerId);
        lobby.addMember(playerId2);

        assertNotEquals(playerId, lobby.members().get(1));
    }*/

    @Test
    void availableSeats_3SeatsAvailable_isAccepted(){

        PlayerId playerId = new PlayerId("p-7f3a");

        Lobby lobby = lobbyFactory.create(playerId);

        assertEquals(3, lobby.availableSeats());

    }


}
