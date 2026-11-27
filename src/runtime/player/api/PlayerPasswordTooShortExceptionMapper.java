package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.PlayerPasswordTooShortException;

@Provider
public class PlayerPasswordTooShortExceptionMapper
        extends PlayerExceptionMapper<PlayerPasswordTooShortException> {

    final static int CODE = 422;
    final static String MSG = "PASSWORD_TOO_SHORT";

    @Override
    public Response toResponse(PlayerPasswordTooShortException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
