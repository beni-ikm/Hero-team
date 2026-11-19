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

    public PlayerResource(
            CreatePlayerUseCase createAccountUseCase,
            CreatePlayerRequestMapper requestMapper) {
        this.createAccountUseCase = createAccountUseCase;
        this.requestMapper = requestMapper;
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
}
