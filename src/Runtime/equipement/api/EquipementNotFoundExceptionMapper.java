package Runtime.equipement.api;

import Runtime.equipement.domain.exception.EquipementNotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class EquipementNotFoundExceptionMapper implements ExceptionMapper<EquipementNotFoundException> {
    @Override
    public Response toResponse(EquipementNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }
}
