package Combat.Bestiaire;

import Combat.Combatant;
import java.util.List;
import java.util.Random;

public class RandomHeroBehavior implements CreatureBehavior {
    private final Random random;

    public RandomHeroBehavior() {
        this(new Random());
    }

    public RandomHeroBehavior(Random random) {
        this.random = random;
    }

    @Override
    public Combatant chooseTarget(List<Combatant> candidates) {
        List<Combatant> validHeroes = candidates.stream()
            .filter(c -> c.isHero() && !c.isKnockedOut())
            .toList();

        if (validHeroes.isEmpty()) {
            return candidates.stream()
                .filter(c -> !c.isKnockedOut())
                .findFirst()
                .orElse(null);
        }

        return validHeroes.get(random.nextInt(validHeroes.size()));
    }
}
