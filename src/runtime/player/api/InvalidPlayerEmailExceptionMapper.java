package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.InvalidPlayerEmailException;

@Provider
public class InvalidPlayerEmailExceptionMapper
        extends PlayerExceptionMapper<InvalidPlayerEmailException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(InvalidPlayerEmailException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
