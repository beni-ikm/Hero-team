package runtime.player.application;

public record CreatePlayerCommand(
        String playerId,
        String pseudonym,
        String email,
        String password) {}
