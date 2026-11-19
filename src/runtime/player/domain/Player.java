package runtime.player.domain;

import java.util.Objects;

public class Player {

    private final PlayerId id;
    private final PlayerUserId userId;
    private final PlayerPseudonym pseudonym;
    private final PlayerEmail email;
    private final PlayerPassword password;

    public Player(
            PlayerId id,
            PlayerUserId userId,
            PlayerPseudonym pseudonym,
            PlayerEmail email,
            PlayerPassword password) {

        this.id = Objects.requireNonNull(id);
        this.userId = Objects.requireNonNull(userId);
        this.pseudonym = Objects.requireNonNull(pseudonym);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);

    }

    public boolean isOwnedBy(PlayerUserId user) { return userId.equals(user); }

    public PlayerId playerId() { return id; }

    public PlayerUserId playerUserId() { return userId; }

    public PlayerPseudonym playerPseudonym() { return pseudonym; }

    public PlayerEmail playerEmail() { return email; }

    public PlayerPassword playerPassword() { return password; }

    @Override
    public boolean equals(Object other) { return other instanceof Player player && id.equals(player.id); }

    @Override
    public int hashCode() { return id.hashCode(); }


}
