package Runtime.Hero.domain;

import Runtime.Hero.domain.exception.HeroAttributesOverTheLimitException;
import Runtime.Hero.domain.exception.HeroAttributesUnderTheLimitException;
import Runtime.Hero.domain.exception.HeroModificatorBonusOverTheLimitException;
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
    private int mana;

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
        this.health = validFinalAttribute(validInitialAttribute(health) + job.getBaseJobHealth());
        this.strength = validFinalAttribute(validInitialAttribute(strength) + species.getSpeciesStrength());
        this.dexterity = validFinalAttribute(validInitialAttribute(dexterity) + species.getSpeciesDexterity());
        this.intelligence = validFinalAttribute(validInitialAttribute(intelligence) + species.getSpeciesIntelligence());
        this.constitution = validFinalAttribute(validInitialAttribute(constitution) + species.getSpeciesConstitution());
        this.charisma = validFinalAttribute(validInitialAttribute(charisma) + species.getSpeciesCharisma());
        this.wisdom = validFinalAttribute(validInitialAttribute(wisdom) + species.getSpeciesWisdom());
        this.mana = job.getBaseJobMana();

    }

    private int validInitialAttribute(int attribute) {
        if ( 3 > attribute) {
            throw new HeroAttributesUnderTheLimitException("Introduced attribute is too low");
        } else if (attribute > 18) {
            throw new HeroAttributesOverTheLimitException("Introduced attribute is too high");
        }
        return attribute;
    }
    private int validFinalAttribute(int attribute) {
        if (attribute > 20) {
            throw new HeroModificatorBonusOverTheLimitException("The combined attributes are over the limit that is 20 points");
        }
        return attribute;
    }

}
