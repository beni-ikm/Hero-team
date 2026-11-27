package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.PlayerPseudonymTooLongException;

@Provider
public class PlayerPseudonymTooLongExceptionMapper
        extends PlayerExceptionMapper<PlayerPseudonymTooLongException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(PlayerPseudonymTooLongException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
