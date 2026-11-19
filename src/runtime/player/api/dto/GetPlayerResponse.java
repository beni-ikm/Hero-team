package runtime.player.api.dto;

public record GetPlayerResponse(
        String id, String pseudonym, String email) {
}
