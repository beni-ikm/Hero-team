package Runtime.Hero.domain;

import Runtime.classes.Classes;
import Runtime.species.Species;

// Cette classe contient seulement les arguments (voir parameter object ppw)
public record HeroCreationArgs(String name, Species species, Classes job,
                               int health, int strength, int dexterity,
                               int intelligence, int constitution,
                               int charisma, int wisdom) {
}
