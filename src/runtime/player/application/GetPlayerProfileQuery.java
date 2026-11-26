package runtime.player.application;

public record GetPlayerProfileQuery(String requesterPlayerId, String targetPlayerId) {}