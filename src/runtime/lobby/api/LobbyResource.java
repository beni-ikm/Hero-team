package runtime.lobby.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import runtime.lobby.application.LeaveLobbyCommand;
import runtime.lobby.application.LeaveLobbyUseCase;
import runtime.shared.api.AuthExtractor;
import runtime.shared.api.TokenAuthenticator;

@Path("/lobbies")
@Produces(MediaType.APPLICATION_JSON)
public class LobbyResource {

    private final LeaveLobbyUseCase leaveLobbyUseCase;
    private final TokenAuthenticator tokenAuthenticator;

    @Inject
    public LobbyResource(LeaveLobbyUseCase leaveLobbyUseCase, TokenAuthenticator tokenAuthenticator) {
        this.leaveLobbyUseCase = leaveLobbyUseCase;
        this.tokenAuthenticator = tokenAuthenticator;
    }

    @DELETE
    @Path("/{lobbyId}/players/{playerId}")
    public Response leaveLobby(
            @Context HttpHeaders headers,
            @PathParam("lobbyId") String lobbyId,
            @PathParam("playerId") String playerId) {

        String requesterId = AuthExtractor.requirePlayerId(headers, tokenAuthenticator);
        leaveLobbyUseCase.execute(new LeaveLobbyCommand(requesterId, lobbyId, playerId));
        return Response.noContent().build();
    }
}