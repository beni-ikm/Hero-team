package HeroCreationBetterVersion;
// Cette classe contient seulement les arguments (voir parameter object ppw)
public record HeroCreationArgs(String name, Species species, Class job,
                               Stats health, Stats strength, Stats dexterity,
                               Stats intelligence, Stats constitution,
                               Stats charisma, Stats wisdom) {
}
