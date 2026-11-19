package runtime.combat.bestiaire;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class Bestiaire {
    private final Map<String, CreatureDefinition> definitions = new LinkedHashMap<>();

    public Bestiaire(CreatureDefinitionSource source) {
        if (source == null) {
            throw new BestiaireChargementException("La source du bestiaire est obligatoire.");
        }
        source.loadDefinitions().forEach(this::enregistrer);
    }

    public static Bestiaire parDefaut() {
        return new Bestiaire(new DefaultCreatureDefinitions());
    }

    public void enregistrer(CreatureDefinition definition) {
        if (definition == null) {
            throw new DefinitionCreatureInvalideException("La définition de créature est obligatoire.");
        }
        definitions.put(definition.name().catalogKey(), definition);
    }

    public boolean contient(String nom) {
        return trouverDefinition(nom).isPresent();
    }

    public Optional<CreatureDefinition> trouverDefinition(String nom) {
        if (nom == null || nom.isBlank()) {
            return Optional.empty();
        }
        return Optional.ofNullable(definitions.get(new CreatureName(nom).catalogKey()));
    }

    public CreatureDefinition obtenirDefinition(String nom) {
        return trouverDefinition(nom)
            .orElseThrow(() -> new CreatureNonTrouveeException(nom));
    }

    public Collection<CreatureDefinition> obtenirToutesLesDefinitions() {
        return Collections.unmodifiableCollection(definitions.values());
    }

    public Creature creerCreature(String nom) {
        return creerCreature(nom, UUID.randomUUID().toString());
    }

    public Creature creerCreature(String nom, String identifiant) {
        return obtenirDefinition(nom).spawn(identifiant);
    }
}
