package runtime.player.domain;

import java.util.Objects;
import java.util.UUID;

public record PlayerId(String value) {

    public PlayerId {
        Objects.requireNonNull(value);
    }

    public static PlayerId generate() {
        return new PlayerId(UUID.randomUUID().toString());
    }

}
