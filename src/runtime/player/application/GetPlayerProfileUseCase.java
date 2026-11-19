package runtime.player.application;

import runtime.player.domain.Player;
import runtime.player.domain.PlayerRepository;
import runtime.shared.api.ApiException;

import java.util.Objects;

public class GetPlayerProfileUseCase {

    private final PlayerRepository playerRepository;

    public GetPlayerProfileUseCase(PlayerRepository playerRepository) {
        this.playerRepository = Objects.requireNonNull(playerRepository);
    }

    public PlayerProfileOutput execute(GetPlayerProfileQuery query) {
        if (!query.requesterPlayerId().equals(query.targetPlayerId())) {
            throw new ApiException(403, "FORBIDDEN", "Vous ne pouvez consulter que votre propre profil.");
        }

        Player player = playerRepository.findById(query.targetPlayerId())
                .orElseThrow(() -> new ApiException(404, "PLAYER_NOT_FOUND", "Joueur introuvable."));

        return new PlayerProfileOutput(player.id(), player.pseudonym(), player.email());
    }
}