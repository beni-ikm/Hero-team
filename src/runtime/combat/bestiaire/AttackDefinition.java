package runtime.combat.bestiaire;

public record AttackDefinition(String name, int attackBonus, DamageDice damage) {
    public AttackDefinition {
        if (name == null || name.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le nom de l'attaque ne peut pas être vide.");
        }
        if (damage == null) {
            throw new DefinitionCreatureInvalideException("Les dégâts de l'attaque sont obligatoires.");
        }
    }

    public int damageDiceCount() {
        return damage.diceCount();
    }

    public int damageDiceFaces() {
        return damage.diceFaces();
    }

    public int flatDamageBonus() {
        return damage.flatBonus();
    }
}
