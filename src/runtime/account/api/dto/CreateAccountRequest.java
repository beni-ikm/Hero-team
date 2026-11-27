package runtime.account.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import runtime.account.domain.AccountEmail;
import runtime.account.domain.AccountPassword;

public record CreateAccountRequest(
        @NotNull String pseudonym,
        @NotNull @Valid AccountEmail email,
        @NotNull AccountPassword password) {
}

