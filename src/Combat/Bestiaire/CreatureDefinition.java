package Combat.Bestiaire;

public record CreatureDefinition(
    String name,
    int maxHitPoints,
    int armorClass,
    int initiativeBonus,
    int experiencePoints,
    AttackDefinition attack,
    String behaviorType
) {
    public CreatureDefinition {
        if (name == null || name.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le nom de la créature ne peut pas être vide.");
        }
        if (maxHitPoints <= 0) {
            throw new DefinitionCreatureInvalideException("Les points de vie doivent être supérieurs à zéro.");
        }
        if (armorClass < 0) {
            throw new DefinitionCreatureInvalideException("La classe d'armure ne peut pas être négative.");
        }
        if (experiencePoints < 0) {
            throw new DefinitionCreatureInvalideException("L'expérience ne peut pas être négative.");
        }
        if (attack == null) {
            throw new DefinitionCreatureInvalideException("L'attaque de la créature est obligatoire.");
        }
        if (behaviorType == null || behaviorType.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le type de comportement est obligatoire.");
        }
    }
}
