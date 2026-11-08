package runtime.account.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import runtime.account.api.dto.CreateAccountRequest;
import runtime.account.application.*;

import java.net.URI;

@Path("/account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private final CreateAccountUseCase createAccountUseCase;
    private final CreateAccountRequestMapper requestMapper;
    private final GetAccountUseCase getAccountUseCase;
    private final AccountResponseMapper responseMapper;

    public AccountResource(
            CreateAccountUseCase createAccountUseCase,
            CreateAccountRequestMapper requestMapper,
            GetAccountUseCase getAccountUseCase,
            AccountResponseMapper responseMapper) {
        this.createAccountUseCase = createAccountUseCase;
        this.requestMapper = requestMapper;
        this.getAccountUseCase = getAccountUseCase;
        this.responseMapper = responseMapper;
    }

    @POST
    public Response createAccount(
            @HeaderParam("User") @NotNull String userId,
            @NotNull @Valid CreateAccountRequest request,
            @Context UriInfo uriInfo) {

        CreateAccountCommand command = requestMapper.toCommand(userId, request);

        AccountOutput account = createAccountUseCase.execute(command);

        URI location = uriInfo.getAbsolutePathBuilder().path(account.id()).build();
        return Response.created(location).build();
    }

    @GET
    @Path("{id}")
    public Response getAccount(
            @HeaderParam("Pseudonym") @NotNull String userId,
            @PathParam("id") String accountId) {

        GetAccountQuery query = new GetAccountQuery(accountId, userId);
        AccountOutput account = getAccountUseCase.execute(query);

        return Response.ok(responseMapper.toResponse(account)).build();

    }



}
