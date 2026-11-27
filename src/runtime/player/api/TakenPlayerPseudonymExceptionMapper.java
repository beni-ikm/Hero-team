package runtime.player.api;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.player.domain.exception.TakenPlayerPseudonymException;

@Provider
public class TakenPlayerPseudonymExceptionMapper
        extends PlayerExceptionMapper<TakenPlayerPseudonymException>{

    final static int CODE = 409;
    final static String MSG = "PSEUDONYM_TAKEN";

    @Override
    public Response toResponse(TakenPlayerPseudonymException exception) {
        return buildErrorResponse(CODE, MSG, exception);
    }

}
