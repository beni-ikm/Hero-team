package runtime.lobby.application;

public record LeaveLobbyCommand(String requesterPlayerId, String lobbyId, String targetPlayerId) {}