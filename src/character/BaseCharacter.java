package character;

import classes.Job;
import species.CharacterSpecies;
import character.Name;

public class BaseCharacter {

    private Name name;
    private CharacterSpecies species;
    private Job profession;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;
    private int charisma;
    private int wisdom;
    private int level;
    private int experience;

    public BaseCharacter(
            // Basic character info
            Name name, CharacterSpecies species, Job profession,
            // Common stats
            int health, int strength, int dexterity,
            int intelligence, int constitution, int charisma, int wisdom) {
        this.name = name;
        this.species = species;
        this.profession = profession;

    }

}
