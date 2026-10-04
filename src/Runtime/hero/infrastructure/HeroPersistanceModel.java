package Runtime.hero.infrastructure;

public record HeroPersistanceModel (
        String id,
        String playerId,
        String name,
        String species,
        String job,
        int health,
        int strength,
        int dexterity,
        int intelligence,
        int constitution,
        int charisma,
        int wisdom
) {
}
