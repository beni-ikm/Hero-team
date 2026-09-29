package Runtime.Hero.domain;

import Runtime.Hero.domain.exception.HeroAttributesOverTheLimitException;
import Runtime.Hero.domain.exception.HeroAttributesUnderTheLimitException;
import Runtime.classes.Classes;
import Runtime.species.Species;

import java.util.UUID;

public class Hero {

    private Name name;
    UUID uuid;
    private Species species;
    private Classes job;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int charisma;
    private int wisdom;

    public UUID uuid() {
        return uuid;
    }

    public Hero(Name name, Species species, Classes job,
                int health, int strength, int dexterity, int intelligence,
                int constitution, int charisma, int wisdom){
        this.name = name;
        this.uuid = uuid();
        this.species = species;
        this.job = job;
        this.health = validAttribute(health);
        this.strength = validAttribute(strength);
        this.dexterity = validAttribute(dexterity);
        this.intelligence = validAttribute(intelligence);
        this.constitution = validAttribute(constitution);
        this.charisma = validAttribute(charisma);
        this.wisdom = validAttribute(wisdom);

    }

    private int validAttribute(int attribute) {
        if ( 3 > attribute) {
            throw new HeroAttributesUnderTheLimitException("Introduced attribute is too low");
        } else if (attribute > 18) {
            throw new HeroAttributesOverTheLimitException("Introduced attribute is too high");
        }
        return attribute;
    }

}
