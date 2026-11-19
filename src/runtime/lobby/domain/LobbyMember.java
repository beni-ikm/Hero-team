package runtime.lobby.domain;

import java.util.Objects;

public class LobbyMember {
    private final String playerId;
    private final String pseudonym;
    private String selectedHeroId;

    public LobbyMember(String playerId, String pseudonym, String selectedHeroId) {
        this.playerId = Objects.requireNonNull(playerId);
        this.pseudonym = Objects.requireNonNull(pseudonym);
        this.selectedHeroId = selectedHeroId;
    }

    public String playerId() { return playerId; }
    public String pseudonym() { return pseudonym; }
    public String selectedHeroId() { return selectedHeroId; }
    public void clearHero() { this.selectedHeroId = null; }
}