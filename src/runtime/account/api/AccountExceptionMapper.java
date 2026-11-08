package runtime.account.api;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import runtime.account.domain.exception.AccountException;

public class AccountExceptionMapper implements ExceptionMapper<AccountException> {

    private final static int UNPROCESSABLE_CONTENT = 422;

    @Override
    public Response toResponse(AccountException exception) {
        return Response.status(UNPROCESSABLE_CONTENT)
                .type(MediaType.TEXT_PLAIN)
                .entity(exception.getMessage())
                .build();
    }

}
