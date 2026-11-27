package runtime.player.infrastructure;

public record PlayerPersistenceModel(
        String playerId,
        String pseudonym,
        String email,
        String password) {}
