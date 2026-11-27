package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.PlayerPseudonymTooShortException;

@Provider
public class PlayerPseudonymTooShortExceptionMapper
        extends PlayerExceptionMapper<PlayerPseudonymTooShortException>{

    final static int CODE = 400;
    final static String MSG = "INVALID_REQUEST";

    @Override
    public Response toResponse(PlayerPseudonymTooShortException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
