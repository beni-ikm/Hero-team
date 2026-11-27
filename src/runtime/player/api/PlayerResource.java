package runtime.player.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.HttpHeaders;
import runtime.player.api.dto.CreatePlayerRequest;
import runtime.player.api.dto.PlayerProfileResponse;
import runtime.player.application.*;
import runtime.shared.api.AuthExtractor;
import runtime.shared.api.TokenAuthenticator;
import runtime.player.application.GetPlayerProfileUseCase;
import runtime.player.application.GetPlayerProfileQuery;
import runtime.player.application.PlayerProfileOutput;
import runtime.shared.api.TokenAuthenticator;
import runtime.shared.api.AuthExtractor;
import java.net.URI;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import runtime.player.api.dto.CreatePlayerRequest;
import runtime.player.application.*;

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final CreatePlayerUseCase createAccountUseCase;
    private final CreatePlayerRequestMapper requestMapper;
    private final GetPlayerUseCase getPlayerUseCase;
    private final PlayerResponseMapper responseMapper;
    private final GetPlayerProfileUseCase getPlayerProfileUseCase;
    private final TokenAuthenticator tokenAuthenticator;

    @Inject
    public PlayerResource(
            CreatePlayerUseCase createAccountUseCase,
            CreatePlayerRequestMapper requestMapper,
            GetPlayerUseCase getPlayerUseCase,
            PlayerResponseMapper responseMapper,
            GetPlayerProfileUseCase getPlayerProfileUseCase,
            TokenAuthenticator tokenAuthenticator) {
        this.createAccountUseCase = createAccountUseCase;
        this.requestMapper = requestMapper;
        this.getPlayerUseCase = getPlayerUseCase;
        this.responseMapper = responseMapper;
        this.getPlayerProfileUseCase = getPlayerProfileUseCase;
        this.tokenAuthenticator = tokenAuthenticator;
    }

    @POST
    public Response createAccount(
            @HeaderParam("User") @NotNull String userId,
            @NotNull @Valid CreatePlayerRequest request,
            @Context UriInfo uriInfo) {

        CreatePlayerCommand command = requestMapper.toCommand(userId, request);

        PlayerOutput account = createAccountUseCase.execute(command);

        URI location = uriInfo.getAbsolutePathBuilder().path(account.id()).build();
        return Response.created(location).build();
    }

    @GET
    @Path("/{playerId}")
    public Response getPlayer(
            @HeaderParam("Pseudonym") @NotNull String userId,
            @PathParam("id") String accountId) {

        GetPlayerQuery query = new GetPlayerQuery(accountId, userId);
        PlayerOutput account = getPlayerUseCase.execute(query);

        return Response.ok(responseMapper.toResponse(account)).build();

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