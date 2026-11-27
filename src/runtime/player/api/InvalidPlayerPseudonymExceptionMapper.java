package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.InvalidPlayerPseudonymException;

@Provider
public class InvalidPlayerPseudonymExceptionMapper
        extends PlayerExceptionMapper<InvalidPlayerPseudonymException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(InvalidPlayerPseudonymException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
