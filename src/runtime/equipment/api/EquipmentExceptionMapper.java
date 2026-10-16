package runtime.equipment.api;

import runtime.equipment.domain.exception.EquipmentException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;


public class EquipmentExceptionMapper implements ExceptionMapper<EquipmentException> {
    private static final int UNPROCESSABLE_CONTENT = 422;

    @Override
    public Response toResponse(EquipmentException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
