package runtime.account.infrastructure;

public record AccountPersistenceModel(
        String id,
        String accountUserId,
        String pseudonym,
        String email,
        String password) {}
