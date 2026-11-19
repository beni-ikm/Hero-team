package runtime.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import runtime.player.domain.exception.PlayerException;

public class PlayerExceptionMapper implements ExceptionMapper<PlayerException> {

    private final static int UNPROCESSABLE_CONTENT = 422;

    @Override
    public Response toResponse(PlayerException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }

}
