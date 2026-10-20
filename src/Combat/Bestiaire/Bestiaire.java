package Combat.Bestiaire;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Bestiaire {
    private final Map<String, CreatureDefinition> definitions = new LinkedHashMap<>();

    public Bestiaire() {
        chargerCreaturesParDefaut();
    }

    public void enregistrer(CreatureDefinition definition) {
        if (definition == null) {
            throw new DefinitionCreatureInvalideException("La définition de créature ne peut pas être null.");
        }
        definitions.put(normaliserNom(definition.name()), definition);
    }

    public boolean contient(String nom) {
        if (nom == null) {
            return false;
        }
        return definitions.containsKey(normaliserNom(nom));
    }

    public Optional<CreatureDefinition> trouverDefinition(String nom) {
        if (nom == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(definitions.get(normaliserNom(nom)));
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
        CreatureDefinition definition = obtenirDefinition(nom);
        return new Creature(identifiant, definition);
    }

    public void chargerDepuisFichierJson(Path chemin) {
        BestiaireJsonLoader.chargerDansBestiaire(this, chemin);
    }

    public void chargerDepuisJson(String json) {
        for (CreatureDefinition def : BestiaireJsonLoader.chargerDepuisJson(json)) {
            enregistrer(def);
        }
    }

    public void vider() {
        definitions.clear();
    }

    public void chargerCreaturesParDefaut() {
        enregistrer(new CreatureDefinition(
            "Gobelin",
            7,
            12,
            2,
            50,
            new AttackDefinition("Dague rouillée", 3, 1, 6, 1),
            "WEAKEST_HERO"
        ));

        enregistrer(new CreatureDefinition(
            "Orc",
            15,
            13,
            1,
            100,
            new AttackDefinition("Hache", 4, 1, 8, 2),
            "STRONGEST_HERO"
        ));

        enregistrer(new CreatureDefinition(
            "Troll",
            35,
            15,
            0,
            300,
            new AttackDefinition("Massue", 6, 2, 6, 3),
            "RANDOM_HERO"
        ));
    }

    private String normaliserNom(String nom) {
        return nom.trim().toLowerCase();
    }
}
