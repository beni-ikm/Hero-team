package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.TakenPlayerEmailException;

@Provider
public class TakenPlayerEmailExceptionMapper
        extends PlayerExceptionMapper<TakenPlayerEmailException>{

    final static int CODE = 409;
    final static String MSG = "EMAIL_TAKEN";

    @Override
    public Response toResponse(TakenPlayerEmailException exception) {

        return buildErrorResponse(CODE, MSG, exception);
    }

}
