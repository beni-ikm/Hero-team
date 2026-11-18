package runtime.lobby.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import runtime.lobby.api.dto.LobbyResponse;
import runtime.lobby.application.CreateLobbyCommand;
import runtime.lobby.application.CreateLobbyUseCase;
import runtime.lobby.application.LobbyOutput;

import java.net.URI;

@Path("/lobbies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LobbyRessource {

    private final CreateLobbyUseCase createLobbyUseCase;
    private final LobbyResponseMapper responseMapper;

    public LobbyRessource(CreateLobbyUseCase lobbyUseCase, LobbyResponseMapper responseMapper) {
        this.createLobbyUseCase = lobbyUseCase;
        this.responseMapper = responseMapper;
    }

    @POST
    public Response createLobby(
            @Context SecurityContext securityContext) {

        String playerId = securityContext.getUserPrincipal().getName();

        CreateLobbyCommand command = new CreateLobbyCommand(playerId);

        LobbyOutput output = createLobbyUseCase.excute(command);

        LobbyResponse response = responseMapper.toResponse(output);

        URI location = URI.create("/lobbies/"+ output.id());

        return Response.created(location)
                .entity(response)
                .build();
    }

}
