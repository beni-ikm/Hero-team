package runtime.combat.bestiaire;

import java.util.Locale;

public record CreatureName(String value) {
    public CreatureName {
        if (value == null || value.isBlank()) {
            throw new DefinitionCreatureInvalideException("Le nom de la créature ne peut pas être vide.");
        }
        value = value.trim();
    }

    public String catalogKey() {
        return value.toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return value;
    }
}
