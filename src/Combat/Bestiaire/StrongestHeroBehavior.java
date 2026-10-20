package Combat.Bestiaire;

import Combat.Combatant;
import java.util.Comparator;
import java.util.List;

public class StrongestHeroBehavior implements CreatureBehavior {
    @Override
    public Combatant chooseTarget(List<Combatant> candidates) {
        return candidates.stream()
            .filter(c -> c.isHero() && !c.isKnockedOut())
            .max(Comparator.comparingInt(Combatant::getCurrentHitPoints))
            .orElseGet(() -> candidates.stream()
                .filter(c -> !c.isKnockedOut())
                .findFirst()
                .orElse(null));
    }
}
