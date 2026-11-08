package runtime.account.api;

import runtime.account.api.dto.CreateAccountRequest;
import runtime.account.application.CreateAccountCommand;

public class CreateAccountRequestMapper {

    public CreateAccountCommand toCommand(String userId, CreateAccountRequest request) {
        return new CreateAccountCommand(
                userId,
                request.pseudonym(),
                request.email().value(),
                request.password().value());
    }

}
