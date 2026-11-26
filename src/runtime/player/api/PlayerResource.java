package runtime.player.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import runtime.player.api.dto.PlayerProfileResponse;
import runtime.player.application.GetPlayerProfileQuery;
import runtime.player.application.GetPlayerProfileUseCase;
import runtime.player.application.PlayerProfileOutput;
import runtime.shared.api.AuthExtractor;
import runtime.shared.api.TokenAuthenticator;

@Path("/players")
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final GetPlayerProfileUseCase getPlayerProfileUseCase;
    private final TokenAuthenticator tokenAuthenticator;

    @Inject
    public PlayerResource(GetPlayerProfileUseCase getPlayerProfileUseCase, TokenAuthenticator tokenAuthenticator) {
        this.getPlayerProfileUseCase = getPlayerProfileUseCase;
        this.tokenAuthenticator = tokenAuthenticator;
    }

    @GET
    @Path("/{playerId}")
    public Response getProfile(
            @Context HttpHeaders headers,
            @PathParam("playerId") String playerId) {

        String requesterId = AuthExtractor.requirePlayerId(headers, tokenAuthenticator);
        PlayerProfileOutput output = getPlayerProfileUseCase.execute(
                new GetPlayerProfileQuery(requesterId, playerId)
        );

        PlayerProfileResponse response = new PlayerProfileResponse(
                output.id(), output.pseudonym(), output.email()
        );
        return Response.ok(response).build();
    }
}