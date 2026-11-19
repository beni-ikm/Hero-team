package runtime.combat.bestiaire;

import java.util.Locale;
import java.util.function.Supplier;

public enum BehaviorType {
    WEAKEST_HERO(WeakestHeroBehavior::new),
    STRONGEST_HERO(StrongestHeroBehavior::new),
    RANDOM_HERO(RandomHeroBehavior::new);

    private final Supplier<CreatureBehavior> behaviorSupplier;

    BehaviorType(Supplier<CreatureBehavior> behaviorSupplier) {
        this.behaviorSupplier = behaviorSupplier;
    }

    public CreatureBehavior createBehavior() {
        return behaviorSupplier.get();
    }

    public static BehaviorType fromCode(String code) {
        if (code == null || code.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le type de comportement est obligatoire.");
        }
        try {
            return valueOf(code.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unknownCode) {
            throw new DefinitionCreatureInvalideException("Comportement inconnu : " + code);
        }
    }
}
