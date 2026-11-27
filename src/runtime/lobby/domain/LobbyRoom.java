package runtime.lobby.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LobbyRoom {
    public static final int MAX_PLAYERS = 4;

    private final String id;
    private LobbyState state;
    private String hostId;
    // Insertion order = join order, so index 0 is always the earliest arrival
    private final List<LobbyMember> members;

    public LobbyRoom(String id, String hostId, List<LobbyMember> initialMembers) {
        this.id = Objects.requireNonNull(id);
        this.hostId = Objects.requireNonNull(hostId);
        this.state = LobbyState.OPEN;
        this.members = new ArrayList<>(Objects.requireNonNull(initialMembers));
    }

    public boolean hasMember(String playerId) {
        return members.stream().anyMatch(m -> m.playerId().equals(playerId));
    }

    public void removeMember(String playerId) {
        boolean removed = members.removeIf(m -> m.playerId().equals(playerId));
        if (!removed) {
            throw new IllegalStateException("Player not in lobby");
        }

        if (members.isEmpty()) {
            this.state = LobbyState.CLOSED;
            this.hostId = null;
            return;
        }

        if (playerId.equals(this.hostId)) {
            this.hostId = members.get(0).playerId();
        }
    }

    public String id() { return id; }
    public LobbyState state() { return state; }
    public String hostId() { return hostId; }
    public List<LobbyMember> members() { return Collections.unmodifiableList(members); }
}