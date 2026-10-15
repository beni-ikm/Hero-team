package runtime.equipementpackage.api;

import runtime.equipementpackage.domain.exception.EquipementException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;


public class EquipementExceptionMapper implements ExceptionMapper<EquipementException> {
    private static final int UNPROCESSABLE_CONTENT = 422;

    @Override
    public Response toResponse(EquipementException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
