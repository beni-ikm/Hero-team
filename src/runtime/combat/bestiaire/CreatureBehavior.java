package runtime.combat.bestiaire;

import runtime.combat.Combatant;

import java.util.List;
import java.util.Optional;

public interface CreatureBehavior {
    Optional<Combatant> chooseTarget(List<Combatant> candidates);
}
