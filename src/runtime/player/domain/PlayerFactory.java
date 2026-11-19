package runtime.player.domain;

public class PlayerFactory {

    public Player create(
            String playerUserId,
            String pseudonym,
            String email,
            String password) {
        return new Player(
                PlayerId.generate(),
                new PlayerUserId(playerUserId),
                new PlayerPseudonym(pseudonym),
                new PlayerEmail(email),
                new PlayerPassword(password));
    }
}
