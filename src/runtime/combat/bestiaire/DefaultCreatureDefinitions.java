package runtime.combat.bestiaire;

import java.util.List;

public class DefaultCreatureDefinitions implements CreatureDefinitionSource {
    @Override
    public List<CreatureDefinition> loadDefinitions() {
        return List.of(goblin(), orc(), troll());
    }

    private CreatureDefinition goblin() {
        return new CreatureDefinition(
            new CreatureName("Gobelin"), 7, 12, 2, 50,
            new AttackDefinition("Dague rouillée", 3, DamageDice.parse("1d6 + 1")),
            BehaviorType.WEAKEST_HERO
        );
    }

    private CreatureDefinition orc() {
        return new CreatureDefinition(
            new CreatureName("Orc"), 15, 13, 1, 100,
            new AttackDefinition("Hache", 4, DamageDice.parse("1d8 + 2")),
            BehaviorType.STRONGEST_HERO
        );
    }

    private CreatureDefinition troll() {
        return new CreatureDefinition(
            new CreatureName("Troll"), 35, 15, 0, 300,
            new AttackDefinition("Massue", 6, DamageDice.parse("2d6 + 3")),
            BehaviorType.RANDOM_HERO
        );
    }
}
