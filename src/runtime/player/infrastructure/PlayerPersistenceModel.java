package runtime.player.infrastructure;

public record PlayerPersistenceModel(
        String id,
        String accountUserId,
        String pseudonym,
        String email,
        String password) {}
