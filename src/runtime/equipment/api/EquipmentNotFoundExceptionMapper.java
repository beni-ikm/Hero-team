package runtime.equipment.api;

import runtime.equipment.domain.exception.EquipmentNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class EquipmentNotFoundExceptionMapper implements ExceptionMapper<EquipmentNotFoundException> {
    @Override
    public Response toResponse(EquipmentNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
