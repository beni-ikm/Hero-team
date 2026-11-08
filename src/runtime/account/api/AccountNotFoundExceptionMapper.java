package runtime.account.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import runtime.account.domain.exception.AccountNotFoundException;

@Provider
public class AccountNotFoundExceptionMapper {

    //@Override
    public Response toResponse(AccountNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }

}
