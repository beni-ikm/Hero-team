package runtime.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.PlayerNotFoundException;

@Provider
public class PlayerNotFoundExceptionMapper {

    //@Override
    public Response toResponse(PlayerNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }

}
