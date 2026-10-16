package runtime.hero.domain;

import runtime.classes.Classes;
import runtime.species.Species;

// Cette classe contient seulement les arguments (voir parameter object ppw)
public record HeroCreationArgs(String name, Species species, Classes job,
                               int health, int strength, int dexterity,
                               int intelligence, int constitution,
                               int charisma, int wisdom) {
}
