package runtime.combat.bestiaire;

import runtime.combat.Combatant;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Creature implements Combatant {
    private final String id;
    private final CreatureDefinition definition;
    private final AttackDefinition attack;
    private final CreatureBehavior behavior;

    private HitPoints hitPoints;
    private int initiativeScore;
    private boolean defending;
    private boolean hasActedThisTurn;

    public Creature(String id, CreatureDefinition definition, CreatureBehavior behavior) {
        if (id == null || id.isBlank()) {
            throw new DefinitionCreatureInvalideException("L'identifiant de la créature ne peut pas être vide.");
        }
        if (definition == null) {
            throw new DefinitionCreatureInvalideException("La définition de la créature est obligatoire.");
        }
        if (behavior == null) {
            throw new DefinitionCreatureInvalideException("Le comportement de la créature est obligatoire.");
        }
        this.id = id;
        this.definition = definition;
        this.attack = definition.attack();
        this.behavior = behavior;
        this.hitPoints = HitPoints.full(definition.maxHitPoints());
    }

    public Optional<Combatant> chooseTarget(List<Combatant> candidates) {
        return behavior.chooseTarget(candidates);
    }

    @Override
    public void takeDamage(int amount) {
        hitPoints = hitPoints.afterDamage(amount);
    }

    public void heal(int amount) {
        if (!isKnockedOut()) {
            hitPoints = hitPoints.afterHealing(amount);
        }
    }

    @Override
    public boolean isKnockedOut() {
        return hitPoints.isDepleted();
    }

    @Override
    public boolean isHero() {
        return false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return definition.name().value();
    }

    @Override
    public int getArmorClass() {
        return definition.armorClass();
    }

    @Override
    public int getInitiativeBonus() {
        return definition.initiativeBonus();
    }

    @Override
    public int getInitiativeScore() {
        return initiativeScore;
    }

    @Override
    public void setInitiativeScore(int score) {
        this.initiativeScore = score;
    }

    @Override
    public boolean isDefending() {
        return defending;
    }

    @Override
    public void setDefending(boolean defending) {
        this.defending = defending;
    }

    @Override
    public boolean hasActedThisTurn() {
        return hasActedThisTurn;
    }

    @Override
    public void setHasActedThisTurn(boolean hasActed) {
        this.hasActedThisTurn = hasActed;
    }

    @Override
    public void resetTurnState() {
        this.hasActedThisTurn = false;
    }

    @Override
    public int getWeaponDiceCount() {
        return attack.damageDiceCount();
    }

    @Override
    public int getWeaponDiceFaces() {
        return attack.damageDiceFaces();
    }

    @Override
    public String getWeaponAssociatedStat() {
        return attack.name();
    }

    @Override
    public int getStatModifier(String statName) {
        return attack.flatDamageBonus();
    }

    @Override
    public int getProficiencyBonus() {
        return attack.attackBonus();
    }

    @Override
    public int getCurrentHitPoints() {
        return hitPoints.current();
    }

    public int getMaxHitPoints() {
        return hitPoints.maximum();
    }

    public int getExperiencePoints() {
        return definition.experiencePoints();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Creature creature)) {
            return false;
        }
        return id.equals(creature.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
