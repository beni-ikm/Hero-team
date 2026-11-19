package runtime.combat.bestiaire;

import runtime.combat.Combatant;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

final class ActiveHeroes {
    private final List<Combatant> heroes;

    private ActiveHeroes(List<Combatant> heroes) {
        this.heroes = heroes;
    }

    static ActiveHeroes among(List<Combatant> candidates) {
        return new ActiveHeroes(candidates.stream()
            .filter(Combatant::isHero)
            .filter(candidate -> !candidate.isKnockedOut())
            .toList());
    }

    Optional<Combatant> withLowestHitPoints() {
        return heroes.stream().min(Comparator.comparingInt(Combatant::getCurrentHitPoints));
    }

    Optional<Combatant> withHighestHitPoints() {
        return heroes.stream().max(Comparator.comparingInt(Combatant::getCurrentHitPoints));
    }

    Optional<Combatant> pickedAtRandom(Random random) {
        if (heroes.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(heroes.get(random.nextInt(heroes.size())));
    }
}
