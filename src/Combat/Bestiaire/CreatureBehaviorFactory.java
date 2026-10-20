package Combat.Bestiaire;

public class CreatureBehaviorFactory {
    public static CreatureBehavior create(String behaviorType) {
        if (behaviorType == null) {
            throw new DefinitionCreatureInvalideException("Le type de comportement ne peut pas être null.");
        }

        return switch (behaviorType.toUpperCase().trim()) {
            case "WEAKEST_HERO", "GOBELIN", "GOBELIN_BEHAVIOR" -> new WeakestHeroBehavior();
            case "STRONGEST_HERO", "ORC", "ORC_BEHAVIOR" -> new StrongestHeroBehavior();
            case "RANDOM_HERO", "TROLL", "TROLL_BEHAVIOR" -> new RandomHeroBehavior();
            default -> throw new DefinitionCreatureInvalideException("Comportement inconnu: " + behaviorType);
        };
    }
}
