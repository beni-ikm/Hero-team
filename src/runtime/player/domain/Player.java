package runtime.player.domain;

import java.util.Objects;

public class Player {

    private final PlayerId id;
    private final PlayerPseudonym pseudonym;
    private final PlayerEmail email;
    private final PlayerPassword password;

    public Player(
            PlayerId id,
            PlayerPseudonym pseudonym,
            PlayerEmail email,
            PlayerPassword password) {

        this.id = Objects.requireNonNull(id);
        this.pseudonym = Objects.requireNonNull(pseudonym);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);

    }

    public PlayerId playerId() { return id; }

    public PlayerPseudonym playerPseudonym() { return pseudonym; }

    public PlayerEmail playerEmail() { return email; }

    public PlayerPassword playerPassword() { return password; }

    @Override
    public boolean equals(Object other) { return other instanceof Player player && id.equals(player.id); }

    @Override
    public int hashCode() { return id.hashCode(); }


}
