package Combat.Bestiaire;

import Combat.Combatant;
import java.util.List;

public interface CreatureBehavior {
    Combatant chooseTarget(List<Combatant> candidates);
}
