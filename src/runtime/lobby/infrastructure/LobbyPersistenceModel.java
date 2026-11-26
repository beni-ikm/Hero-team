package runtime.lobby.infrastructure;

import java.util.List;

public record LobbyPersistenceModel(
        String id,
        String host,
        List<String> members,
        boolean open) {}
