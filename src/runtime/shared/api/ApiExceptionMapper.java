package runtime.shared.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<ApiException> {

    @Override
    public Response toResponse(ApiException ex) {
        return Response.status(ex.statusCode())
                .type(MediaType.APPLICATION_JSON)
                .entity(new ApiError(ex.errorCode(), ex.getMessage()))
                .build();
    }
}