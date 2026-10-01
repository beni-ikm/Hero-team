package Runtime.lobby.domain;

import Runtime.hero.domain.Hero;

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
