package runtime.player.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import runtime.player.api.dto.CreatePlayerRequest;
import runtime.player.application.*;

import java.net.URI;

@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    private final CreatePlayerUseCase createAccountUseCase;
    private final CreatePlayerRequestMapper requestMapper;
    private final GetPlayerUseCase getPlayerUseCase;
    private final PlayerResponseMapper responseMapper;

    public PlayerResource(
            CreatePlayerUseCase createAccountUseCase,
            CreatePlayerRequestMapper requestMapper,
            GetPlayerUseCase getPlayerUseCase,
            PlayerResponseMapper responseMapper) {
        this.createAccountUseCase = createAccountUseCase;
        this.requestMapper = requestMapper;
        this.getPlayerUseCase = getPlayerUseCase;
        this.responseMapper = responseMapper;
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
    @Path("{id}")
    public Response getAccount(
            @HeaderParam("Pseudonym") @NotNull String userId,
            @PathParam("id") String accountId) {

        GetPlayerQuery query = new GetPlayerQuery(accountId, userId);
        PlayerOutput account = getPlayerUseCase.execute(query);

        return Response.ok(responseMapper.toResponse(account)).build();

    }



}
