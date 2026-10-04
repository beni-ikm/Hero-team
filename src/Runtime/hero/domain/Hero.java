package Runtime.hero.domain;

import Runtime.classes.Classes;
import Runtime.species.Species;

import java.util.Objects;
import java.util.UUID;

public class Hero {

    UUID uuid;

    private final Name name;
    private final UUID id;
    private final PlayerId playerId;
    private final Species species;
    private final Classes job;
    private final Attribute health;
    private final
    private final


    public UUID uuid() {
        return uuid;
    }

    public Hero(Name name, PlayerId playerId, Species species, Classes job,
                int health, int strength, int dexterity,
                int intelligence, int constitution,
                int charisma, int wisdom){
        this.name = Objects.requireNonNull(name);
        this.id = Objects.requireNonNull(uuid());
        this.playerId = Objects.requireNonNull(playerId);
        this.species = Objects.requireNonNull(species);
        this.job = Objects.requireNonNull(job);
        this
    }

}
