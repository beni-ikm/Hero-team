package runtime.player.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import runtime.player.domain.exception.PlayerException;

public abstract class PlayerExceptionMapper<E extends PlayerException> implements  ExceptionMapper<E>{

    public record ErrorResponse(String error, String message){}

    protected Response buildErrorResponse(int httpStatus, String errorCode, E exception) {
        return Response.status(httpStatus)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(errorCode, exception.getMessage()))
                .build();
    }

}
