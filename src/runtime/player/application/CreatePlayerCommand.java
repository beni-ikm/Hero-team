package runtime.player.application;

public record CreatePlayerCommand(
        String playerUserId,
        String pseudonym,
        String email,
        String password) {}
