package runtime.player.application;

public record PlayerOutput(
        String id,
        String playerUserId,
        String pseudonym,
        String email,
        String password) {}
