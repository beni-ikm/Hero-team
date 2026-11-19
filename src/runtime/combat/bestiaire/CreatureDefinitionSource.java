package runtime.combat.bestiaire;

import java.util.List;

public interface CreatureDefinitionSource {
    List<CreatureDefinition> loadDefinitions();
}
