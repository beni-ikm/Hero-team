package runtime.account.application;

public record CreateAccountCommand(
        String accountUserId,
        String pseudonym,
        String email,
        String password) {}
