package runtime.combat.bestiaire;

import runtime.combat.Combatant;
import java.util.List;

public interface CreatureBehavior {
    Combatant chooseTarget(List<Combatant> candidates);
}
