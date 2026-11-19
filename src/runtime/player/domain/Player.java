package runtime.player.domain;

import java.util.Objects;

public class Player {
    private final String id;
    private final String pseudonym;
    private final String email;
    private final String passwordHash;

    public Player(String id, String pseudonym, String email, String passwordHash) {
        this.id = Objects.requireNonNull(id);
        this.pseudonym = Objects.requireNonNull(pseudonym);
        this.email = Objects.requireNonNull(email);
        this.passwordHash = Objects.requireNonNull(passwordHash);
    }

    public String id() { return id; }
    public String pseudonym() { return pseudonym; }
    public String email() { return email; }
    public String passwordHash() { return passwordHash; }
}
