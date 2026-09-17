package HeroCreationBetterVersion;
// Cette classe contient seulement les arguments (voir parameter object ppw)
public record HeroCreationArgs(String name, Species species, Class job,
                               int health, int strength, int dexterity,
                               int intelligence, int constitution,
                               int charisma, int wisdom) {
}
