package Combat.Bestiaire;

import Combat.Combatant;
import java.util.Comparator;
import java.util.List;

public class WeakestHeroBehavior implements CreatureBehavior {
    @Override
    public Combatant chooseTarget(List<Combatant> candidates) {
        return candidates.stream()
            .filter(c -> c.isHero() && !c.isKnockedOut())
            .min(Comparator.comparingInt(Combatant::getCurrentHitPoints))
            .orElseGet(() -> candidates.stream()
                .filter(c -> !c.isKnockedOut())
                .findFirst()
                .orElse(null));
    }
}
