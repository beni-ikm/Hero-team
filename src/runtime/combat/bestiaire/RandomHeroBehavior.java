package runtime.combat.bestiaire;

import runtime.combat.Combatant;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class RandomHeroBehavior implements CreatureBehavior {
    private final Random random;

    public RandomHeroBehavior() {
        this(new Random());
    }

    public RandomHeroBehavior(Random random) {
        if (random == null) {
            throw new DefinitionCreatureInvalideException("Le générateur aléatoire est obligatoire.");
        }
        this.random = random;
    }

    @Override
    public Optional<Combatant> chooseTarget(List<Combatant> candidates) {
        return ActiveHeroes.among(candidates).pickedAtRandom(random);
    }
}
