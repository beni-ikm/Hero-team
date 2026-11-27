package runtime.player.domain;

public class PlayerFactory {

    public Player create(
            PlayerPseudonym pseudonym,
            PlayerEmail email,
            PlayerPassword password) {

        return new Player(
                PlayerId.generate(),
                pseudonym,
                email,
                password
        );

    }

}
