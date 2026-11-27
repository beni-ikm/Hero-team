package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.PlayerException;

@Provider
public class InvalidPlayerExceptionMapper
        extends PlayerExceptionMapper<PlayerException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(PlayerException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
