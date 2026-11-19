package runtime.combat.bestiaire;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonCreatureDefinitionSource implements CreatureDefinitionSource {
    private static final Pattern OBJECT_PATTERN = Pattern.compile("\\{([^{}]+(?:\\{[^{}]*\\}[^{}]*)*)\\}");

    private final Path file;

    public JsonCreatureDefinitionSource(Path file) {
        if (file == null) {
            throw new BestiaireChargementException("Le chemin du fichier JSON est obligatoire.");
        }
        this.file = file;
    }

    @Override
    public List<CreatureDefinition> loadDefinitions() {
        return parseDefinitions(readFile());
    }

    private String readFile() {
        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new BestiaireChargementException("Impossible de lire le fichier JSON : " + file, e);
        }
    }

    private List<CreatureDefinition> parseDefinitions(String json) {
        if (json.isBlank()) {
            throw new BestiaireChargementException("Le contenu JSON est vide.");
        }

        List<CreatureDefinition> definitions = new ArrayList<>();
        Matcher objectMatcher = OBJECT_PATTERN.matcher(json);
        while (objectMatcher.find()) {
            String block = objectMatcher.group(0);
            if (describesCreature(block)) {
                definitions.add(toDefinition(block));
            }
        }

        if (definitions.isEmpty()) {
            throw new BestiaireChargementException("Aucune définition de créature trouvée dans le JSON.");
        }
        return definitions;
    }

    private boolean describesCreature(String block) {
        return block.contains("\"attack\"") || block.contains("\"maxHitPoints\"");
    }

    private CreatureDefinition toDefinition(String creatureJson) {
        try {
            String attackJson = nestedObject(creatureJson, "attack");
            AttackDefinition attack = new AttackDefinition(
                text(attackJson, "name"),
                integer(attackJson, "bonus"),
                DamageDice.parse(text(attackJson, "damageExpression"))
            );
            return new CreatureDefinition(
                new CreatureName(text(creatureJson, "name")),
                integer(creatureJson, "maxHitPoints"),
                integer(creatureJson, "armorClass"),
                integer(creatureJson, "initiativeBonus"),
                integer(creatureJson, "experiencePoints"),
                attack,
                BehaviorType.fromCode(text(creatureJson, "behaviorType"))
            );
        } catch (BestiaireException invalidCreature) {
            throw new BestiaireChargementException(
                "Format de créature JSON invalide : " + invalidCreature.getMessage(), invalidCreature);
        }
    }

    private String text(String json, String key) {
        Matcher matcher = Pattern.compile("\"" + key + "\"\\s*:\\s*\"([^\"]*)\"").matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new BestiaireChargementException("Propriété manquante dans le JSON : " + key);
    }

    private int integer(String json, String key) {
        Matcher matcher = Pattern.compile("\"" + key + "\"\\s*:\\s*(-?\\d+)").matcher(json);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        throw new BestiaireChargementException("Propriété entière manquante dans le JSON : " + key);
    }

    private String nestedObject(String json, String key) {
        Matcher matcher = Pattern.compile("\"" + key + "\"\\s*:\\s*\\{([^{}]*)\\}").matcher(json);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new BestiaireChargementException("Sous-objet manquant dans le JSON : " + key);
    }
}
