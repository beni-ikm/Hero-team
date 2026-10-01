/*
 * PROBLÈME
 * Le Lobby actuel gère directement des héros (joinLobby(Hero)), alors que
 * l'énoncé précise qu'un lobby accueille un maximum de quatre JOUEURS et que
 * chaque joueur y SÉLECTIONNE ensuite un héros qu'il a préalablement créé.
 *
 * CONSÉQUENCES
 * - La notion de joueur n'existe pas : le système ne peut pas savoir à qui
 *   appartient chaque héros.
 * - Un joueur ne peut pas entrer dans le lobby avant d'avoir choisi son héros,
 *   ni en changer.
 * - Rien n'empêche quelqu'un de sélectionner le héros d'un autre joueur.
 * - startGame() lance la partie dès qu'un seul héros est présent, sans vérifier
 *   que les joueurs sont prêts. Ça contredit la règle « lorsque les joueurs sont
 *   prêts, la partie peut être lancée ».
 * - Pour l'API, « rejoindre un lobby » et « sélectionner un héros » doivent être
 *   deux actions distinctes, et le serveur (source de vérité) doit faire
 *   respecter ces règles lui-même.
 *
 * CE QU'ON DOIT FAIRE
 * Le lobby doit gérer des joueurs plutôt que des héros :
 * - join(playerId) / leave(playerId) : entrer et sortir, maximum 4 joueurs.
 * - selectHero(playerId, hero) : associer un héros à un joueur; deux joueurs
 *   ne peuvent pas choisir le même héros.
 * - setReady(playerId) : permis seulement après avoir choisi un héros.
 * - startGame() : lance la partie seulement si tous les joueurs sont prêts,
 *   et retourne les héros sélectionnés, qui forment le groupe de l'aventure.
 */

package Runtime.Hero.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Lobby {

    public static final int MAX_HEROES = 4;

    private final UUID lobbyId;
    private final List<Hero> heroes;
    private boolean isGameStarted;

    public Lobby() {
        this.lobbyId = UUID.randomUUID();
        this.heroes = new ArrayList<>();
        this.isGameStarted = false;
    }


    public void joinLobby(Hero preCreatedHero) {

        Objects.requireNonNull(preCreatedHero, "Un héros créé préalablement est requis pour rejoindre le lobby.");

        if (isGameStarted) {
            throw new IllegalStateException("Impossible de rejoindre: la partie a déjà commencé.");
        }


        if (heroes.size() >= MAX_HEROES) {
            throw new IllegalStateException("Impossible de rejoindre: le lobby est complet (maximum " + MAX_HEROES + " héros).");
        }

        if (heroes.contains(preCreatedHero)) {
            throw new IllegalArgumentException("Ce héros est déjà présent dans le lobby.");
        }

        this.heroes.add(preCreatedHero);
    }

    public void leaveLobby(Hero hero) {
        if (isGameStarted) {
            throw new IllegalStateException("Impossible de quitter le lobby pendant la partie.");
        }
        this.heroes.remove(hero);
    }

    public void startGame() {
        if (heroes.isEmpty()) {
            throw new IllegalStateException("Au moins 1 héros est requis pour lancer la partie.");
        }
        this.isGameStarted = true;
    }

    public UUID getLobbyId() {
        return lobbyId;
    }

    public List<Hero> getHeroes() {
        return Collections.unmodifiableList(heroes);
    }

    public boolean isFull() {
        return heroes.size() >= MAX_HEROES;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }
}