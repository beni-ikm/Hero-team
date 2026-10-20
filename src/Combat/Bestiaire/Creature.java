package Combat.Bestiaire;

import Combat.Combatant;
import java.util.List;
import java.util.UUID;

public class Creature implements Combatant {
    private final String id;
    private final String name;
    private final int maxHitPoints;
    private final int armorClass;
    private final int initiativeBonus;
    private final int experiencePoints;
    private final AttackDefinition attack;
    private final CreatureBehavior behavior;

    private int currentHitPoints;
    private int initiativeScore;
    private boolean defending;
    private boolean hasActedThisTurn;

    public Creature(CreatureDefinition definition) {
        this(UUID.randomUUID().toString(), definition, CreatureBehaviorFactory.create(definition.behaviorType()));
    }

    public Creature(String id, CreatureDefinition definition) {
        this(id, definition, CreatureBehaviorFactory.create(definition.behaviorType()));
    }

    public Creature(String id, CreatureDefinition definition, CreatureBehavior behavior) {
        this(
            id,
            definition.name(),
            definition.maxHitPoints(),
            definition.armorClass(),
            definition.initiativeBonus(),
            definition.experiencePoints(),
            definition.attack(),
            behavior
        );
    }

    public Creature(
        String id,
        String name,
        int maxHitPoints,
        int armorClass,
        int initiativeBonus,
        int experiencePoints,
        AttackDefinition attack,
        CreatureBehavior behavior
    ) {
        if (id == null || id.isBlank()) {
            throw new DefinitionCreatureInvalideException("L'identifiant de la créature ne peut pas être vide.");
        }
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
        if (behavior == null) {
            throw new DefinitionCreatureInvalideException("Le comportement de la créature est obligatoire.");
        }

        this.id = id;
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = maxHitPoints;
        this.armorClass = armorClass;
        this.initiativeBonus = initiativeBonus;
        this.experiencePoints = experiencePoints;
        this.attack = attack;
        this.behavior = behavior;
        this.defending = false;
        this.hasActedThisTurn = false;
    }

    public Combatant selectTarget(List<Combatant> candidates) {
        return behavior.chooseTarget(candidates);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getArmorClass() {
        return armorClass;
    }

    @Override
    public int getInitiativeBonus() {
        return initiativeBonus;
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
    public boolean isHero() {
        return false;
    }

    @Override
    public boolean isKnockedOut() {
        return currentHitPoints <= 0;
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > 0) {
            currentHitPoints = Math.max(0, currentHitPoints - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0 && !isKnockedOut()) {
            currentHitPoints = Math.min(maxHitPoints, currentHitPoints + amount);
        }
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
        return attack.diceCount();
    }

    @Override
    public int getWeaponDiceFaces() {
        return attack.diceFaces();
    }

    @Override
    public String getWeaponAssociatedStat() {
        return attack.name();
    }

    @Override
    public int getStatModifier(String statName) {
        return attack.damageBonus();
    }

    @Override
    public int getProficiencyBonus() {
        return attack.bonus();
    }

    @Override
    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public AttackDefinition getAttack() {
        return attack;
    }

    public CreatureBehavior getBehavior() {
        return behavior;
    }
}
