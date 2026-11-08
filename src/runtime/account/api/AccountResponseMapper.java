package runtime.account.api;

import runtime.account.api.dto.GetAccountResponse;
import runtime.account.application.AccountOutput;

public class AccountResponseMapper {

    public GetAccountResponse toResponse(AccountOutput account) {
        return new GetAccountResponse(
                account.id(),
                account.pseudonym(),
                account.email());
    }

}
