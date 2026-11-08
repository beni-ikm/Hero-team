package runtime.account.application;

public record AccountOutput(
        String id,
        String accountUserId,
        String pseudonym,
        String email,
        String password) {}
