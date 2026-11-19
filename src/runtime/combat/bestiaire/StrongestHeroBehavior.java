package runtime.combat.bestiaire;

import runtime.combat.Combatant;

import java.util.List;
import java.util.Optional;

public class StrongestHeroBehavior implements CreatureBehavior {
    @Override
    public Optional<Combatant> chooseTarget(List<Combatant> candidates) {
        return ActiveHeroes.among(candidates).withHighestHitPoints();
    }
}
