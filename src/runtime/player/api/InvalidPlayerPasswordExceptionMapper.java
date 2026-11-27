package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.InvalidPlayerPasswordException;

@Provider
public class InvalidPlayerPasswordExceptionMapper
        extends PlayerExceptionMapper<InvalidPlayerPasswordException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(InvalidPlayerPasswordException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
