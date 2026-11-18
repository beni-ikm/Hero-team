package runtime.lobby.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import runtime.lobby.domain.exception.LobbyException;

public class LobbyExceptionMapper implements ExceptionMapper<LobbyException> {

    private static final int CONFLICT = 409;

    @Override
    public Response toResponse(LobbyException e) {
        return Response.status(CONFLICT)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(e.getMessage()))
                .build();
    }

    public record ErrorResponse(String error) {}
}
